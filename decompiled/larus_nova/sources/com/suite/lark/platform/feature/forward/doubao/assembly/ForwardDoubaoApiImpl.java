package com.suite.lark.platform.feature.forward.doubao.assembly;

import android.content.Context;
import android.os.SystemClock;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem;
import com.ss.android.lark.forwardv3.configuration.targetconfig.GroupConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchReplyInThreadInfo;
import com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo;
import com.ss.android.lark.search.dto.info.SearchThreadInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.feature.forward.doubao.api.entity.ForwardDoubaoContent;
import com.suite.lark.platform.feature.forward.doubao.api.entity.ForwardScene;
import com.suite.lark.platform.feature.forward.doubao.i;
import com.suite.lark.platform.feature.forward.doubao.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.GroupingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes36.dex */
@OfficeSDKUserScope
public final class ForwardDoubaoApiImpl implements mpc.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f461281c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f461282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f461283b;

    public static final class a {
    }

    static {
    }

    @Inject
    public ForwardDoubaoApiImpl() {
        this.f461282a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f461283b = new g();
    }

    @Override // mpc.f
    public final void B(List<byte[]> r100) {
        Intrinsics.checkNotNullParameter(r100, "serMessages");
        if (((ArrayList) r100).isEmpty() == false) goto L6;
        Log.w("ForwardDoubaoApiImpl", "deleteLarkMessagesInDoubao ignored: serMessages is empty");
        return;
    L6:
        BuildersKt.launch$default(this.f461282a, null, null, new ForwardDoubaoApiImpl$deleteLarkMessagesInDoubao$1(r100, null), 3, null);
    }

    public static final npc.c a(ForwardDoubaoApiImpl r100, SearchBaseInfo r101) {
        r100.getClass();
        boolean r102 = r101 instanceof SearchChatterInfo;
        if (r102 == false) goto L7;
        SearchChatterInfo r103 = (SearchChatterInfo) r101;
        String r104 = r103.getTitle();
        if (r104 != null) goto L9;
        r104 = r103.getName();
    L9:
        if (r102 == false) goto L12;
        String r105 = ((SearchChatterInfo) r101).getP2pChatId();
        if (r105 == null) goto L12;
    L13:
        npc.c r106 = new npc.c();
        String r107 = r101.getId();
        if (r107 != null) goto L16;
        r107 = "";
    L16:
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r106.f520073a = r107;
        String r108 = r101.getAvatarKey();
        if (r108 != null) goto L19;
        r108 = "";
    L19:
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r106.f520074b = r108;
        if (r104 != null) goto L22;
        r104 = "";
    L22:
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r106.f520075c = r104;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r106.f520078f = r105;
        if ((r101 instanceof SearchChatterInfo) == false) goto L26;
    L27:
        int r109 = 1;
    L38:
        r106.f520077e = r109;
        return r106;
    L26:
        if ((r101 instanceof SearchShieldP2PChatInfo) == true) goto L27;
        if ((r101 instanceof SearchChatInfo) == false) goto L32;
        r109 = 2;
        goto L38
    L32:
        if ((r101 instanceof SearchThreadInfo) == false) goto L34;
    L37:
        r109 = 3;
        goto L38
    L34:
        if ((r101 instanceof SearchReplyInThreadInfo) == true) goto L37;
        r109 = 0;
    L12:
        r105 = "";
        goto L13
    L7:
        r104 = r101.getTitle();
        goto L9
    }

    @Override // mpc.f
    public final boolean i1(Context r100, npc.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "request");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(opc.d.a(r100, r101)));     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L12;
        Log.e("ForwardDoubaoApiImpl", "startFileForward failed", r104);
        r103 = Boolean.FALSE;
    L12:
        return ((Boolean) r103).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // mpc.f
    public final void o8(Context r100, npc.d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        v.a(r100, r101);
    }

    @Override // mpc.f
    public final void cc(ForwardScene r110, mpc.g r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "scene");
        Intrinsics.checkNotNullParameter(r111, "callback");
        long r100 = SystemClock.elapsedRealtime();
        IncludeConfig.a r101 = new IncludeConfig.a();
        EntityItem.a r102 = new EntityItem.a();
        r102.f(new UserConfig.a().a());
        r101.a(r102.c());
        EntityItem.a r103 = new EntityItem.a();
        r103.d(new GroupConfig.a().a());
        r101.a(r103.c());
        IncludeConfig r104 = r101.b();
        BuildersKt.launch$default(this.f461282a, null, null, new ForwardDoubaoApiImpl$getRecentForwardList$1(r100, r104, r112, r110, this, r111, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mpc.f
    public final void gf(final Context r110, ForwardDoubaoContent r210, final List r211, final u48.b r212) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r210, "forwardContent");
        Intrinsics.checkNotNullParameter(r211, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r212, "callBack");
        final long r100 = SystemClock.elapsedRealtime();
        List<Long> r101 = r210.getDoubaoMsgIds();
        if (r101.isEmpty() == false) goto L6;
        Log.w("ForwardDoubaoApiImpl", "send failed: doubaoMsgIds is empty, targets=" + ((ArrayList) r211).size());
        r212.onFailure(-1, "doubaoMsgIds is empty");
        return;
    L6:
        ArrayList r102 = (ArrayList) r211;
        if (r102.isEmpty() == false) goto L10;
        Log.w("ForwardDoubaoApiImpl", "send failed: target is empty, msgIds=" + r101.size());
        r212.onFailure(-1, "target is empty");
        return;
    L10:
        final String r111 = StringsKt.trim(r210.getTextContent()).toString();
        i.f461352a.update(r210);
        Map r112 = GroupingKt.eachCount(new e(r211));
        if (r211.isEmpty() == false) goto L13;
        int r113 = 0;
    L28:
        StringBuilder r103 = new StringBuilder("send start: msgIds=");
        r103.append(r101.size());
        r103.append(", targets=");
        r103.append(r102.size());
        r103.append(", noteLen=");
        r103.append(r111.length());
        r103.append(", targetTypes=");
        r103.append(r112);
        r103.append(", preloadedP2pChatCount=");
        r103.append(r113);
        r103.append(", doubaoDataSize=");
        byte[] r104 = r210.getDoubaoData();
        if (r104 == null) goto L31;
        int r105 = r104.length;
    L32:
        r103.append(r105);
        Log.i("ForwardDoubaoApiImpl", r103.toString());
        final g r106 = this.f461283b;
        final Function0<Unit> r107 = new ForwardDoubaoApiImpl$send$1(r100, r212);
        final Function1<ErrorResult, Unit> r114 = new ForwardDoubaoApiImpl$send$2(r100, r212);
        r106.getClass();
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "note");
        Intrinsics.checkNotNullParameter(r211, "targets");
        Intrinsics.checkNotNullParameter(r107, "onSuccess");
        Intrinsics.checkNotNullParameter(r114, "onFailed");
        final Function1<List<? extends SearchBaseInfo>, Unit> r108 = new ForwardDoubaoMergeForwardSender$sendMergeForward$1(r110, r111, r107, r114);
        int r109 = r102.size();
        if (r109 != 0) goto L35;
        r108.invoke(CollectionsKt.emptyList());
        return;
    L35:
        final SearchBaseInfo[] r115 = new SearchBaseInfo[r109];
        final ArrayList r116 = new ArrayList();
        int r117 = r211.size();
        int r118 = 0;
    L36:
        if (r118 >= r117) goto L57;
        npc.c r119 = (npc.c) ListProtector.get(r211, r118);
        int r120 = r119.f520077e;
        if (r120 != 1) goto L40;
        String r121 = r119.f520073a;
        if (StringsKt.isBlank(r121) == true) goto L50;
        String r122 = r119.f520078f;
        if ((!StringsKt.isBlank(r122)) == false) goto L54;
        SearchChatterInfo r123 = new SearchChatterInfo();
        r123.setId(r121);
        r123.setP2pChatId(r122);
        r123.setTitle(r119.f520075c);
        r123.setAvatarKey(r119.f520074b);
        r115[r118] = r123;
    L55:
        r118 = r118 + 1;
        goto L36
    L54:
        r116.add(Integer.valueOf(r118));
        goto L55
    L50:
        r114.invoke(new ErrorResult(-1, "chatterId is empty"));
        return;
    L40:
        if (r120 != 2) goto L42;
    L44:
        String r124 = r119.f520073a;
        if (StringsKt.isBlank(r124) == true) goto L46;
        SearchChatInfo r125 = new SearchChatInfo();
        r125.setId(r124);
        r125.setTitle(r119.f520075c);
        r125.setAvatarKey(r119.f520074b);
        Unit r126 = Unit.INSTANCE;
        r115[r118] = r125;
        goto L55
    L46:
        r114.invoke(new ErrorResult(-1, "chatId is empty"));
        return;
    L42:
        if (r120 == 3) goto L44;
        r114.invoke(new ErrorResult(-1, "unknown targetType: " + r119.f520077e));
        return;
    L57:
        if (r116.isEmpty() == false) goto L59;
        r108.invoke(ArraysKt.filterNotNull(r115));
        return;
    L59:
        ArrayList r127 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator r128 = r116.iterator();
    L61:
        if (r128.hasNext() == false) goto L63;
        r127.add(((npc.c) ListProtector.get(r211, ((Number) r128.next()).intValue())).f520073a);
        goto L61
    L63:
        ImSdkService.b().C2(CollectionsKt.distinct(r127), new ForwardDoubaoMergeForwardSender$adaptForwardTargetsToSearchBaseInfos$2(r116, r108, r115, r211, r114, r106));
        return;
    L31:
        r105 = 0;
        goto L32
    L13:
        Iterator r129 = r211.iterator();
        int r130 = 0;
    L15:
        if (r129.hasNext() == false) goto L27;
        npc.c r131 = (npc.c) r129.next();
        if (r131.f520077e == 1) goto L19;
    L21:
        boolean r132 = false;
    L22:
        if (r132 == false) goto L15;
        r130 = r130 + 1;
        if (r130 >= 0) goto L15;
        CollectionsKt.throwCountOverflow();
        goto L15
    L19:
        if ((!StringsKt.isBlank(r131.f520078f)) == false) goto L21;
        r132 = true;
        goto L22
    L27:
        r113 = r130;
        goto L28
    }

    @Override // mpc.f
    public final boolean g1(Context r100, npc.a r101, List r102, String r103, u48.c r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "targets");
        Intrinsics.checkNotNullParameter(r103, "note");
        Intrinsics.checkNotNullParameter(r104, "callback");
        if (r101.a() == true) goto L5;
        return false;
    L5:
        if (((ArrayList) r102).isEmpty() == true) goto L24;
        int r105 = opc.d.f524827a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UICallbackExecutor.execute(new opc.c(r100));
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L10
        com.suite.lark.platform.feature.forward.doubao.assembly.a r107 = com.suite.lark.platform.feature.forward.doubao.assembly.a.f461289a;     // Catch: Throwable -> L10
        f r108 = new f(r104);     // Catch: Throwable -> L10
        r107.getClass();     // Catch: Throwable -> L10
        Object r109 = Result.m9449constructorimpl(Boolean.valueOf(com.suite.lark.platform.feature.forward.doubao.assembly.a.a(r101, r102, r103, r108)));     // Catch: Throwable -> L10
    L12:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L16;
        Log.e("ForwardDoubaoApiImpl", "sendFile failed before request", r110);
        r109 = Boolean.FALSE;
    L16:
        boolean r111 = ((Boolean) r109).booleanValue();
        if (r111 == true) goto L19;
        int r112 = opc.d.f524827a;
        UICallbackExecutor.post(opc.b.f524825a);
    L19:
        return r111;
    L10:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L24:
        return false;
    }

    @Override // mpc.f
    public final void g8(Context r100, ImageView r101, String r102, String r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "imageView");
        Intrinsics.checkNotNullParameter(r102, "avatarKey");
        Intrinsics.checkNotNullParameter(r103, "entityId");
        if (StringsKt.isBlank(r102) == false) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r103) == false) goto L8;
        return;
    L8:
        if (r104 > 0) goto L11;
        r104 = -1;
    L11:
        if (r105 > 0) goto L14;
        r105 = -1;
    L14:
        AvatarImage r106 = AvatarImage.Builder.obtain(r102, r103, r104, r105).isOnlyLocal(false).build();
        IRequestCreator r107 = ImageLoader.with(r100).load(r106);
        r107.transform(new CircleCrop());
        if (r104 <= 0) goto L18;
        if (r105 <= 0) goto L18;
        r107.override(r104, r105);
    L18:
        r107.dontAnimate(true);
        r107.into(r101);
    }
}
