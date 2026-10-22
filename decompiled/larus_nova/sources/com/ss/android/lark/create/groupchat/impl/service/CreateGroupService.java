package com.ss.android.lark.create.groupchat.impl.service;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.lark.pb.im.v1.ChatPageContext;
import com.bytedance.lark.pb.im.v1.CreateChatRequest;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.PickChatEntity;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.contact.base.entity.Contact;
import com.ss.android.lark.create.groupchat.dto.CreateGroupMode;
import com.ss.android.lark.create.groupchat.dto.CreateGroupScene;
import com.ss.android.lark.create.groupchat.dto.GroupCreateInfo;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupExtraParams$Click;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupExtraParams$IsChangeAvatar;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupExtraParams$IsChangeName;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupExtraParams$IsCrypto;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupExtraParams$IsSycn;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupExtraParams$LeaveAMessage;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupExtraParams$Source;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupHitPointNew;
import com.ss.android.lark.doc.entity.DocPermPair;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.v;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchDepartmentInfo;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class CreateGroupService extends c38.a<i> implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f420178c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.create.groupchat.impl.service.b f420179b;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<Context> f420180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Fragment f420181b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f420180a, r101.f420180a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f420181b, r101.f420181b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f420180a.hashCode() * 31;
            Fragment r101 = this.f420181b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "CreateGroupContext(context=" + this.f420180a + ", sourceFragment=" + this.f420181b + ')';
        }

        public final WeakReference<Context> getContext() {
            return this.f420180a;
        }

        public b(WeakReference<Context> r100, Fragment r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f420180a = r100;
            this.f420181b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f420182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f420183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Contact> f420184c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final IGetDataCallback<w5b.a> f420185d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f420186e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f420187f;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f420188a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public List<? extends Contact> f420189b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public IGetDataCallback<w5b.a> f420190c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f420191d;

            public a() {
                this.f420188a = true;
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f420182a == r101.f420182a) goto L12;
            return false;
        L12:
            if (this.f420183b == r101.f420183b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f420184c, r101.f420184c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f420185d, r101.f420185d) == true) goto L21;
            return false;
        L21:
            if (this.f420186e == r101.f420186e) goto L24;
            return false;
        L24:
            if (this.f420187f == r101.f420187f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f420182a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f420183b == false) goto L9;
            int r103 = 1231;
        L10:
            int r104 = (r102 + r103) * 31;
            List<Contact> r105 = this.f420184c;
            int r106 = 0;
            if (r105 != null) goto L13;
            int r107 = 0;
        L14:
            int r108 = (r104 + r107) * 31;
            IGetDataCallback<w5b.a> r109 = this.f420185d;
            if (r109 == null) goto L18;
            r106 = r109.hashCode();
        L18:
            int r110 = (r108 + r106) * 31;
            if (this.f420186e == false) goto L21;
            int r111 = 1231;
        L22:
            int r112 = (r110 + r111) * 31;
            if (this.f420187f == true) goto L27;
            r100 = 1237;
        L27:
            return r112 + r100;
        L21:
            r111 = 1237;
            goto L22
        L13:
            r107 = r105.hashCode();
            goto L14
        L9:
            r103 = 1237;
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "CreateGroupLaunchParams(needOpenChat=" + this.f420182a + ", needBadge=" + this.f420183b + ", contactsToApply=" + this.f420184c + ", extraCallback=" + this.f420185d + ", openApplyGroupLimit=" + this.f420186e + ", onlyBots=" + this.f420187f + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(boolean r100, boolean r101, List<? extends Contact> r102, IGetDataCallback<w5b.a> r103, boolean r104, boolean r105) {
            this.f420182a = r100;
            this.f420183b = r101;
            this.f420184c = r102;
            this.f420185d = r103;
            this.f420186e = r104;
            this.f420187f = r105;
        }
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f420192a = null;

        static {
            int[] r100 = new int[CreateGroupScene.values().length];
            r100[CreateGroupScene.PLUS_MENU.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[CreateGroupScene.P2P.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[CreateGroupScene.ADD_GROUP_MEMBER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[CreateGroupScene.FORWARD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f420192a = r100;
        }
    }

    static {
    }

    @Inject
    public CreateGroupService(b38.b r100, com.ss.android.lark.create.groupchat.impl.service.b r101) {
        Intrinsics.checkNotNullParameter(r100, "rucket");
        Intrinsics.checkNotNullParameter(r101, "createGroupErrorHandle");
        super(r100);
        this.f420179b = r101;
    }

    public final void b(hab.b r110, b r210, CreateGroupScene r211, ErrorResult r212, c r213, Function0<Unit> r214, Function1<? super Boolean, Unit> r215) {
        String r100 = kab.a.f502197a;
        int r101 = r212.getCode();
        String r102 = r212.getMessage();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        String r111 = r102;
        Intrinsics.checkNotNullParameter(r111, "errorMessage");
        kab.a.f502197a = null;
        ErrorParams r112 = new ErrorParams(Biz.Messenger, Scene.Chat, Event.create_group_chat, ErrorType.SDK, ErrorLevel.Fatal, r101, null, null, r111, Boolean.TRUE, null, null, null, AVMDLDataLoader.KeyIsInitialSocketTimeout, null);
        AppreciableKit.Companion.getInstance().error(r112);
        r110.a();
        if (r214 == null) goto L8;
        r214.invoke();
    L8:
        Context r103 = r210.getContext().get();
        if (r103 != null) goto L11;
        return;
    L11:
        com.ss.android.lark.create.groupchat.impl.service.b r104 = this.f420179b;
        Fragment r105 = r210.f420181b;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "scene");
        Intrinsics.checkNotNullParameter(r212, "err");
        List<InterceptorType> r106 = r104.f420197b;
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L13:
        if (r108.hasNext() == false) goto L17;
        Object r109 = r108.next();
        Map<InterceptorType, Provider<com.ss.android.lark.create.groupchat.impl.service.c>> r113 = r104.f420196a;
        if (r113.containsKey((InterceptorType) r109) == false) goto L13;
        r107.add(r109);
        goto L13
    L17:
        ArrayList r114 = new ArrayList();
        Iterator r115 = r107.iterator();
    L19:
        if (r115.hasNext() == false) goto L28;
        InterceptorType r116 = (InterceptorType) r115.next();
        Provider<com.ss.android.lark.create.groupchat.impl.service.c> r117 = r104.f420196a.get(r116);
        if (r117 == null) goto L25;
        com.ss.android.lark.create.groupchat.impl.service.c r118 = r117.get();
        if (r118 == null) goto L25;
        Pair r119 = TuplesKt.to(r116, r118);
    L26:
        if (r119 == null) goto L19;
        r114.add(r119);
    L25:
        r119 = null;
        goto L26
    L28:
        Iterator r120 = MapsKt.toMutableMap(MapsKt.toMap(r114, new LinkedHashMap())).values().iterator();
    L30:
        if (r120.hasNext() == false) goto L48;
        com.ss.android.lark.create.groupchat.impl.service.c r121 = (com.ss.android.lark.create.groupchat.impl.service.c) r120.next();
        if (r121.a(r103, r211, r212, r215, r105, r213) == false) goto L30;
        Log.i("CreateGroupErrorHandle", "intercept success by ".concat(r121.getClass().getSimpleName()));
        return;
    }

    @Override // com.ss.android.lark.create.groupchat.impl.service.h
    public final void Da(Context r110, GroupCreateInfo r210, List<? extends SearchBaseInfo> r211, IGetDataCallback<Chat> r212, CreateGroupScene r213, IGetDataCallback<w5b.a> r214, Fragment r215, hab.b r216) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r210, "groupCreateInfo");
        Intrinsics.checkNotNullParameter(r211, "searchInfos");
        Intrinsics.checkNotNullParameter(r213, "source");
        Intrinsics.checkNotNullParameter(r216, "chatDependency");
        int r100 = com.ss.android.lark.create.groupchat.impl.service.a.f420195a;
        Intrinsics.checkNotNullParameter(r211, "list");
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r211.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if ((r103 instanceof SearchChatterInfo) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        ArrayList r104 = new ArrayList();
        Iterator r105 = r101.iterator();
    L10:
        if (r105.hasNext() == false) goto L14;
        Object r106 = r105.next();
        if (((SearchChatterInfo) r106).isNotContact() == false) goto L10;
        r104.add(r106);
        goto L10
    L14:
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r107 = r104.iterator();
    L16:
        if (r107.hasNext() == false) goto L18;
        SearchBaseInfo r108 = (SearchBaseInfo) r107.next();
        r111.add(new Contact(r108.getId(), r108.getAvatarKey(), r108.getTitle()));
        goto L16
    L18:
        Set r109 = CollectionsKt.toMutableSet(r211);
        r109.removeAll(r104);
        ArrayList r112 = new ArrayList();
        Iterator r113 = r109.iterator();
    L20:
        if (r113.hasNext() == false) goto L33;
        SearchBaseInfo r114 = (SearchBaseInfo) r113.next();
        Intrinsics.checkNotNullParameter(r114, "info");
        if ((r114 instanceof SearchChatInfo) == false) goto L25;
        PickChatEntity r115 = new PickChatEntity(2, r114.getId());
    L31:
        if (r115 == null) goto L20;
        r112.add(r115);
        goto L20
    L25:
        if ((r114 instanceof SearchChatterInfo) == false) goto L28;
        r115 = new PickChatEntity(1, r114.getId());
        goto L31
    L28:
        if ((r114 instanceof SearchDepartmentInfo) == false) goto L30;
        r115 = new PickChatEntity(3, r114.getId());
        goto L31
    L30:
        r115 = null;
        goto L31
    L33:
        com.ss.android.lark.create.groupchat.impl.service.d r116 = new com.ss.android.lark.create.groupchat.impl.service.d();
        String r117 = r210.getName();
        Intrinsics.checkNotNullParameter(r117, "groupName");
        r116.f420202e = r117;
        String r118 = r210.getDescription();
        Intrinsics.checkNotNullParameter(r118, "groupDesc");
        r116.f420203f = r118;
        r116.f420207j = r210.isPublic();
        r116.f420205h = r210.isCrossTenant();
        CreateGroupMode r119 = r210.getMode();
        Intrinsics.checkNotNullParameter(r119, "groupMode");
        int r120 = com.ss.android.lark.create.groupchat.impl.service.d.a.f420210a[r119.ordinal()];
        if (r120 == 1) goto L41;
        if (r120 == 2) goto L40;
        if (r120 != 3) goto L39;
        r116.f420209l = Chat.ChatMode.DEFAULT;
        r116.f420206i = true;
    L42:
        String r121 = r210.getFromChatId();
        Intrinsics.checkNotNullParameter(r121, "fromChatId");
        r116.f420204g = r121;
        r116.f420208k = r210.getLinkedUrl();
        r116.f420199b.clear();
        r116.f420199b.addAll(r112);
        List<String> r122 = CollectionsKt.toMutableList(r116.f420198a);
        LinkedHashSet r123 = new LinkedHashSet(r116.f420199b);
        int r124 = com.ss.android.lark.create.groupchat.impl.service.a.f420195a;
        Intrinsics.checkNotNullParameter(r122, "chatterIds");
        Intrinsics.checkNotNullParameter(r123, "pickEntities");
        Intrinsics.checkNotNullParameter(r123, "sourcePickEntities");
        ArrayList r125 = new ArrayList();
        Iterator r126 = r123.iterator();
    L44:
        if (r126.hasNext() == false) goto L51;
        Object r127 = r126.next();
        if (((PickChatEntity) r127).f415165a != 1) goto L48;
        boolean r128 = true;
    L49:
        if (r128 == false) goto L44;
        r125.add(r127);
        goto L44
    L48:
        r128 = false;
        goto L49
    L51:
        ArrayList r129 = new ArrayList();
        Iterator r130 = r125.iterator();
    L53:
        if (r130.hasNext() == false) goto L57;
        String r131 = ((PickChatEntity) r130.next()).f415166b;
        if (r131 == null) goto L53;
        r129.add(r131);
        goto L53
    L57:
        LinkedHashSet r132 = new LinkedHashSet(Math.max(r122.size(), r129.size()));
        r132.addAll(r122);
        r132.addAll(r129);
        r122.clear();
        r122.addAll(r132);
        List<String> r133 = r122;
        ArrayList r134 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r133, 10));
        Iterator r135 = r133.iterator();
    L59:
        if (r135.hasNext() == false) goto L61;
        r134.add(new PickChatEntity(1, (String) r135.next()));
        goto L59
    L61:
        r123.addAll(r134);
        CreateChatRequest.Builder r136 = new CreateChatRequest.Builder().type(com.bytedance.lark.pb.basic.v1.Chat.Type.GROUP).chatter_ids(r122).group_name(r116.f420202e).group_desc(r116.f420203f).is_crypto(Boolean.valueOf(r116.f420206i)).pick_entities(v.a(r123)).chat_mode(com.bytedance.lark.pb.basic.v1.Chat.ChatMode.fromValue(r116.f420209l.getNumber())).is_public_v2(Boolean.valueOf(r116.f420207j)).init_message_ids(r116.f420200c).from_chat_id(r116.f420204g).is_cross_tenant(Boolean.valueOf(r116.f420205h));
        if ((!r116.f420201d.isEmpty()) == false) goto L76;
        Map<String, Map<String, DocPermPair.PermType>> r137 = r116.f420201d;
        ArrayList r138 = new ArrayList(r137.size());
        Iterator r139 = ((LinkedHashMap) r137).entrySet().iterator();
    L65:
        if (r139.hasNext() == false) goto L75;
        Map.Entry r140 = (Map.Entry) r139.next();
        String r141 = (String) r140.getKey();
        Map r142 = (Map) r140.getValue();
        ArrayList r143 = new ArrayList(r142.size());
        Iterator r144 = r142.entrySet().iterator();
    L68:
        if (r144.hasNext() == false) goto L74;
        Map.Entry r145 = (Map.Entry) r144.next();
        Object r146 = r145.getKey();
        if (((DocPermPair.PermType) r145.getValue()) != DocPermPair.PermType.EDIT) goto L72;
        CreateChatRequest.DocPermission r147 = CreateChatRequest.DocPermission.EDIT;
    L73:
        r143.add(TuplesKt.to(r146, r147));
        goto L68
    L72:
        r147 = CreateChatRequest.DocPermission.READ;
        goto L73
    L74:
        r138.add(TuplesKt.to(r141, new CreateChatRequest.DocPermissions.Builder().perms(MapsKt.toMap(r143)).build()));
        goto L65
    L75:
        r136.message_doc_permissions(MapsKt.toMap(r138));
    L76:
        String r148 = r116.f420208k;
        if (r148 != null) goto L79;
    L84:
        boolean r149 = false;
    L85:
        if (r149 == false) goto L87;
        r136.source(CreateChatRequest.PutChatSource.TO_LINK_PAGE);
        r136.to_link_pages(CollectionsKt.mutableListOf(new ChatPageContext[]{new ChatPageContext.Builder().target_url(r116.f420208k).build()}));
    L87:
        CreateChatRequest r150 = r136.build();
        c.a r151 = new c.a();
        r151.f420188a = r210.isOpenChat();
        boolean r152 = r210.getNeedBadge();
        r151.f420190c = r214;
        r151.f420189b = r111;
        a("createGroupFromPicker", r150, r110, r213, r212, new c(r151.f420188a, r152, r111, r214, false, r151.f420191d), r215, r216);
        return;
    L79:
        if (r148.length() != 0) goto L81;
        boolean r153 = true;
    L82:
        if (r153 == true) goto L84;
        r149 = true;
        goto L85
    L81:
        r153 = false;
        goto L82
    L39:
        throw new NoWhenBranchMatchedException();
    L40:
        r116.f420209l = Chat.ChatMode.THREAD_V2;
        goto L42
    L41:
        r116.f420209l = Chat.ChatMode.DEFAULT;
        goto L42
    }

    public final void a(String r210, CreateChatRequest r211, Context r212, CreateGroupScene r213, IGetDataCallback<Chat> r214, c r215, Fragment r216, final hab.b r310) {
        String r100 = kab.a.f502197a;
        int[] r101 = d.f420192a;
        int r102 = r101[r213.ordinal()];
        if (r102 == 1) goto L7;
        if (r102 == 2) goto L6;
        String r103 = "other";
    L8:
        Intrinsics.checkNotNullParameter(r103, "scene");
        kab.a.f502197a = AppreciableKit.start$default(AppreciableKit.Companion.getInstance(), Biz.Messenger, Scene.Chat, Event.create_group_chat, null, true, null, MapsKt.mapOf(TuplesKt.to("create_group_scene", r103)), null, null, 416, null);
        CreateGroupExtraParams$Click r104 = CreateGroupExtraParams$Click.CONFIRM;
        s5c.h r105 = s5c.h.f540777a;
        int r106 = r101[r213.ordinal()];
        if (r106 == 1) goto L19;
        if (r106 != 2) goto L12;
        CreateGroupExtraParams$Source r107 = CreateGroupExtraParams$Source.FROM_P2P;
    L21:
        if (r211.is_crypto.booleanValue() == false) goto L23;
        CreateGroupExtraParams$IsCrypto r108 = CreateGroupExtraParams$IsCrypto.TRUE;
    L24:
        CreateGroupExtraParams$IsChangeAvatar r109 = CreateGroupExtraParams$IsChangeAvatar.FALSE;
        CreateGroupExtraParams$IsChangeName r110 = CreateGroupExtraParams$IsChangeName.FALSE;
        if ((!r211.init_message_ids.isEmpty()) == false) goto L27;
        CreateGroupExtraParams$IsSycn r111 = CreateGroupExtraParams$IsSycn.TRUE;
    L28:
        CreateGroupExtraParams$LeaveAMessage r112 = CreateGroupExtraParams$LeaveAMessage.FALSE;
        int r113 = CreateGroupHitPointNew.f420247a;
        s5c.d r114 = r104.plus(r105).plus(r107).plus(r108).plus(r109).plus(r110).plus(r111).plus(r112);
        Intrinsics.checkNotNullParameter(r114, "params");
        Statistics.sendEvent("im_group_create_click", s5c.b.a(ChatParamUtils.e(), r114).toJson());
        r310.a();
        jab.c r115 = new jab.c(r211);
        WeakReference r116 = new WeakReference(r212);
        final com.ss.android.lark.sdk.h r117 = new com.ss.android.lark.sdk.h();
        b r118 = new b(r116, r216);
        RucketJob.map$default(((i) this.f22343a.create(i.class)).createGroupChat(r211, new CreateGroupService$createGroupChatInner$1(r117)), null, new CreateGroupService$createGroupChatInner$2(r310), 1, null).then(Dispatchers.getMain(), new CreateGroupService$createGroupChatInner$3(r210, this, r118, r213, r215, r310, r214, r115, null)).error(Dispatchers.getMain(), new CreateGroupService$createGroupChatInner$4(r210, this, r310, r118, r213, r215, r214, r115, r211, r212, null));
        return;
    L27:
        r111 = CreateGroupExtraParams$IsSycn.FALSE;
        goto L28
    L23:
        r108 = CreateGroupExtraParams$IsCrypto.FALSE;
        goto L24
    L12:
        if (r106 != 3) goto L14;
        r107 = CreateGroupExtraParams$Source.FROM_INNER_GROUP;
        goto L21
    L14:
        if (r106 == 4) goto L16;
        r107 = CreateGroupExtraParams$Source.FROM_P2P;
        goto L21
    L16:
        r107 = CreateGroupExtraParams$Source.FROM_FORWARD;
        goto L21
    L19:
        r107 = CreateGroupExtraParams$Source.PLUS;
        goto L21
    L6:
        r103 = "individual_chat";
        goto L8
    L7:
        r103 = "main_menu";
        goto L8
    }
}
