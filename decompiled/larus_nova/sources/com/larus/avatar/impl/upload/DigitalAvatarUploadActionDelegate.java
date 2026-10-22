package com.larus.avatar.impl.upload;

import android.app.Application;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.avatar.impl.upload.adapter.DigitalAvatarUploadItemStatus;
import com.larus.avatar.impl.upload.adapter.DigitalAvatarUploadItemType;
import com.larus.avatar.impl.upload.utils.PreGenImageBitmapHelper;
import com.larus.avatar.impl.upload.viewmodel.DigitalAvatarUploadViewModel;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.api.creation.IBachService;
import com.larus.platform.api.g3;
import com.larus.platform.service.k2;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUploadMediaService;
import com.larus.utils.logger.FLogger;
import ic8.m0;
import ic8.n0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes23.dex */
public final class DigitalAvatarUploadActionDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f291229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleCoroutineScope f291230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f291231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DigitalAvatarUploadViewModel f291232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DigitalAvatarPreGenManager f291233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r f291234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<a> f291235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Unit> f291236h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f291237i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f291238j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f291239k;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/avatar/impl/upload/DigitalAvatarUploadActionDelegate$AddImageResult;", "", "<init>", "(Ljava/lang/String;I)V", "ADDED", "NO_CHANGE", "ABORTED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AddImageResult extends Enum<AddImageResult> {
        public static final AddImageResult ABORTED = null;
        public static final AddImageResult ADDED = null;
        public static final AddImageResult NO_CHANGE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AddImageResult[] f291240a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f291241b = null;

        public static EnumEntries<AddImageResult> getEntries() {
            return f291241b;
        }

        static {
            AddImageResult r100 = new AddImageResult("ADDED", 0);
            ADDED = r100;
            AddImageResult r101 = new AddImageResult("NO_CHANGE", 1);
            NO_CHANGE = r101;
            AddImageResult r102 = new AddImageResult("ABORTED", 2);
            ABORTED = r102;
            AddImageResult[] r103 = {r100, r101, r102};
            f291240a = r103;
            f291241b = EnumEntriesKt.enumEntries(r103);
        }

        public static AddImageResult[] values() {
            return (AddImageResult[]) f291240a.clone();
        }

        public static AddImageResult valueOf(String r100) {
            return (AddImageResult) r27.a.a(AddImageResult.class, r100);
        }

        public AddImageResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f291242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f291243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f291244c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f291242a, r101.f291242a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f291243b, r101.f291243b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f291244c, r101.f291244c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f291242a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((r102 * 31) + this.f291243b.hashCode()) * 31;
            String r104 = this.f291244c;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "ActionContext(replicaCreateId=" + this.f291242a + ", scene=" + this.f291243b + ", enterMethod=" + this.f291244c + ')';
        }

        public a(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "scene");
            this.f291242a = r100;
            this.f291243b = r101;
            this.f291244c = r102;
        }
    }

    public static final class b {
    }

    static {
    }

    public final void d() {
        if (this.f291237i == false) goto L5;
        return;
    L5:
        long r100 = SystemClock.elapsedRealtime();
        if ((r100 - this.f291238j) >= this.f291239k) goto L8;
        return;
    L8:
        this.f291237i = true;
        this.f291238j = r100;
        BuildersKt.launch$default(this.f291230b, null, null, new DigitalAvatarUploadActionDelegate$showUploadFailedToast$1(this, null), 3, null);
    }

    public final void e(Set<? extends Uri> r110, a r111) {
        if (r110.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<T> r100 = this.f291231c.f291316c.iterator();
    L7:
        if (r100.hasNext() == false) goto L21;
        q88.d r101 = (q88.d) r100.next();
        if (r101.f532037a != DigitalAvatarUploadItemType.IMAGE) goto L7;
        if (r101.f532042f == true) goto L7;
        Uri r102 = r101.f532039c;
        if (r102 == null) goto L7;
        if (r110.contains(r102) == false) goto L7;
        DigitalAvatarUploadViewModel r103 = this.f291232d;
        String r104 = r101.f532041e;
        String r105 = r111.f291242a;
        if (r105 != null) goto L20;
        r105 = "null";
    L20:
        r103.uploadImage(r102, r104, r105, r111.f291243b, r111.f291244c);
        goto L7
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0129 -> B:51:0x012e). Please report as a decompilation issue!!! */
    public static final Object a(DigitalAvatarUploadActionDelegate r110, List r111, Continuation r210) {
        r110.getClass();
        if ((r210 instanceof DigitalAvatarUploadActionDelegate$addLocalImages$1) == false) goto L7;
        DigitalAvatarUploadActionDelegate$addLocalImages$1 r100 = (DigitalAvatarUploadActionDelegate$addLocalImages$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
        DigitalAvatarUploadActionDelegate r102 = r110;
    L8:
        Object r103 = r100.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r100.label;
        char r106 = 0;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        Ref.BooleanRef r107 = (Ref.BooleanRef) r100.L$0;
        ResultKt.throwOnFailure(r103);
    L58:
        if (r107.element == false) goto L95;
        r102.f291231c.b();
    L95:
        return AddImageResult.ABORTED;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Uri r108 = (Uri) r100.L$3;
        Iterator r109 = (Iterator) r100.L$2;
        Ref.BooleanRef r112 = (Ref.BooleanRef) r100.L$1;
        Ref.BooleanRef r113 = (Ref.BooleanRef) r100.L$0;
        ResultKt.throwOnFailure(r103);
        Uri r114 = r108;
        Iterator r115 = r109;
        Ref.BooleanRef r116 = r112;
        Ref.BooleanRef r117 = r113;
    L51:
        n0 r118 = (n0) r103;
        String r119 = null;
        if (r118.f489244b != ProcessFileResultCode.PREPARE_OVER_SIZE) goto L61;
        FLogger.f375446a.w("DigitalAvatarUploadAct", "tryAttachmentUpload ProcessResult for OverSize");
        MainCoroutineDispatcher r120 = Dispatchers.getMain();
        DigitalAvatarUploadActionDelegate$addLocalImages$2$1 r121 = new DigitalAvatarUploadActionDelegate$addLocalImages$2$1(null);
        r100.L$0 = r116;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.label = 2;
        if (BuildersKt.withContext(r120, r121, r100) == r104) goto L98;
        r107 = r116;
        goto L58
    L98:
        return r104;
    L61:
        m0 r122 = r118.f489243a;
        if (r122 == null) goto L64;
        r119 = r122.f489227e;
    L64:
        if (r119 != null) goto L66;
    L69:
        boolean r123 = true;
    L70:
        if (r123 == true) goto L72;
        String r124 = r102.f291232d.newPathForKey(r119);
        q88.d r125 = new q88.d(DigitalAvatarUploadItemType.IMAGE, DigitalAvatarUploadItemStatus.UPLOADING, r114, r124, false, 104);
        s r126 = r102.f291231c;
        r126.getClass();
        Intrinsics.checkNotNullParameter(r125, MapController.ITEM_LAYER_TAG);
        r126.d();
        ((ArrayList) r126.f291316c).add(r125);
        r126.b();
        r117.element = true;
        Iterator r127 = r115;
    L76:
        r106 = 0;
    L18:
        if (r127.hasNext() == false) goto L77;
        Uri r128 = (Uri) r127.next();
        if (r116.element == true) goto L23;
        r102.f291231c.d();
        r116.element = true;
    L23:
        if (r102.f291231c.a() > 0) goto L28;
        t19.s r129 = t19.s.f544207a;
        AppHost.Companion r130 = AppHost.f326268a;
        Application r131 = r130.getApplication();
        Application r132 = r130.getApplication();
        Object[] r133 = new Object[1];
        r133[r106] = String.valueOf(r102.f291231c.f291315b);
        String r134 = r132.getString(R.string.larus_mob_ccBot_AIReplica_GenerateScreen_tooMany, r133);
        r129.getClass();
        t19.s.c(r131, r134);
        if (r116.element == false) goto L94;
        r102.f291231c.b();
    L94:
        return AddImageResult.ABORTED;
    L28:
        s r135 = r102.f291231c;
        r135.getClass();
        Intrinsics.checkNotNullParameter(r128, "uri");
        List<q88.d> r136 = r135.f291316c;
        if ((r136 instanceof Collection) == true) goto L31;
    L33:
        Iterator r137 = ((ArrayList) r136).iterator();
    L35:
        if (r137.hasNext() == false) goto L88;
        q88.d r138 = (q88.d) r137.next();
        if (r138.f532037a == DigitalAvatarUploadItemType.IMAGE) goto L39;
    L41:
        boolean r139 = false;
    L42:
        if (r139 == false) goto L35;
        if (1 != 0) goto L76;
    L47:
        IAIChatUploadMediaService.Companion r140 = IAIChatUploadMediaService.f365908a;
        r100.L$0 = r117;
        r100.L$1 = r116;
        r100.L$2 = r127;
        r100.L$3 = r128;
        r100.label = 1;
        Ref.BooleanRef r141 = r117;
        Object r142 = IAIChatUploadMediaService.a.a(r140, r128, null, false, false, "avatar", r100, 30);
        if (r142 == r104) goto L97;
        r117 = r141;
        r114 = r128;
        r115 = r127;
        r103 = r142;
        goto L51
    L97:
        return r104;
    L39:
        if (Intrinsics.areEqual(r138.f532039c, r128) == false) goto L41;
        r139 = true;
    L88:
        if (0 == 0) goto L47;
        goto L76
    L31:
        if (((ArrayList) r136).isEmpty() == false) goto L33;
    L77:
        Ref.BooleanRef r143 = r117;
        if (r143.element == true) goto L83;
        if (r116.element == false) goto L83;
        r102.f291231c.b();
    L83:
        if (r143.element == false) goto L85;
        AddImageResult r144 = AddImageResult.ADDED;
    L87:
        return r144;
    L85:
        r144 = AddImageResult.NO_CHANGE;
        goto L87
    L72:
        if (r116.element == false) goto L96;
        r102.f291231c.b();
    L96:
        return AddImageResult.ABORTED;
    L66:
        if (r119.length() == 0) goto L69;
        r123 = false;
        goto L70
    L16:
        ResultKt.throwOnFailure(r103);
        Ref.BooleanRef r145 = new Ref.BooleanRef();
        r116 = new Ref.BooleanRef();
        r117 = r145;
        r127 = r111.iterator();
    L7:
        r102 = r110;
        r100 = new DigitalAvatarUploadActionDelegate$addLocalImages$1(r102, r210);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.larus.avatar.impl.upload.viewmodel.DigitalAvatarUploadViewModel] */
    /* JADX WARN: Type inference failed for: r13v14, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r13v15, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r13v16, types: [java.util.List] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final Object b(final DigitalAvatarUploadActionDelegate r110, final List r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof DigitalAvatarUploadActionDelegate$handleAlgorithmIfNeed$1) == false) goto L7;
        DigitalAvatarUploadActionDelegate$handleAlgorithmIfNeed$1 r100 = (DigitalAvatarUploadActionDelegate$handleAlgorithmIfNeed$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        List r114 = (List) r100.L$2;
        a r104 = (a) r100.L$1;
        List r105 = (List) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L37:
        r110.f291233e.getClass();
        Intrinsics.checkNotNullParameter(r114, "pairs");
        Iterator r115 = r114.iterator();
    L39:
        if (r115.hasNext() == false) goto L47;
        r88.a r116 = (r88.a) ((Pair) r115.next()).component1();
        PreGenImageBitmapHelper r106 = PreGenImageBitmapHelper.f291320a;
        Bitmap r107 = r116.f536665e;
        r106.getClass();
        if (r107 == null) goto L46;
        if (r107.isRecycled() == true) goto L46;
        r107.recycle();
    L46:
        r116.f536665e = null;
        r116.f536666f = true;
        goto L39
    L47:
        r111 = r105;
        final a r108 = r104;
    L48:
        DigitalAvatarPreGenManager r117 = r110.f291233e;
        if (r117.f291228c.isEmpty() == false) goto L51;
        final ?? r118 = CollectionsKt.emptyList();
    L62:
        if (r111.isEmpty() == true) goto L64;
    L66:
        r110.f291232d.handleAlgorithm(r111, r118, new com.larus.avatar.impl.upload.a(r111, r118, r110, r108));
    L69:
        return Unit.INSTANCE;
    L64:
        if (r118.isEmpty() == false) goto L66;
        return Unit.INSTANCE;
    L51:
        Collection r119 = ((LinkedHashMap) r117.f291228c).values();
        ArrayList r109 = new ArrayList();
        Iterator r120 = r119.iterator();
    L53:
        if (r120.hasNext() == false) goto L57;
        Object r121 = r120.next();
        if (((r88.a) r121).f536666f == false) goto L53;
        r109.add(r121);
        goto L53
    L57:
        r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator r122 = r109.iterator();
    L59:
        if (r122.hasNext() == false) goto L62;
        r118.add(((r88.a) r122.next()).f536664d);
        goto L59
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        a r123 = (a) r100.L$1;
        List r124 = (List) r100.L$0;
        ResultKt.throwOnFailure(r113);
        r108 = r123;
        r111 = r124;
    L27:
        List r125 = (List) r113;
        if ((!r125.isEmpty()) == false) goto L48;
        List r126 = r125;
        ArrayList r127 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r126, 10));
        Iterator r128 = r126.iterator();
    L31:
        if (r128.hasNext() == false) goto L33;
        Pair r129 = (Pair) r128.next();
        r127.add(TuplesKt.to(((r88.a) r129.getFirst()).f536664d, r129.getSecond()));
        goto L31
    L33:
        DigitalAvatarUploadViewModel r130 = r110.f291232d;
        r100.L$0 = r111;
        r100.L$1 = r108;
        r100.L$2 = r125;
        r100.label = 2;
        if (r130.detectPreGenBitmaps(r127, r100) == r102) goto L83;
        r105 = r111;
        r114 = r125;
        r104 = r108;
        goto L37
    L83:
        return r102;
    L16:
        ResultKt.throwOnFailure(r113);
        a r131 = r110.f291235g.invoke();
        if (z2.f365865a.enableClientAvatarDetectAlgorithm() == true) goto L19;
    L21:
        boolean r132 = false;
    L22:
        if (r132 == false) goto L67;
        DigitalAvatarPreGenManager r133 = r110.f291233e;
        r100.L$0 = r111;
        r100.L$1 = r131;
        r100.label = 1;
        Object r134 = r133.a(true, r100);
        if (r134 == r102) goto L82;
        r108 = r131;
        r113 = r134;
        goto L27
    L82:
        return r102;
    L67:
        r110.e(CollectionsKt.toSet(r111), r131);
        goto L69
    L19:
        if (Intrinsics.areEqual(IBachService.f364935a.b().getValue(), Boxing.boxBoolean(true)) == false) goto L21;
        r132 = true;
    L7:
        r100 = new DigitalAvatarUploadActionDelegate$handleAlgorithmIfNeed$1(r110, r112);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.avatar.impl.upload.b] */
    public final void c(final String r100, final String r110, final ActivityResultLauncher<Intent> r111) {
        Intrinsics.checkNotNullParameter(r110, "clickFrom");
        Intrinsics.checkNotNullParameter(r111, "launcher");
        final ?? r101 = new com.larus.avatar.impl.upload.b(this, r110, r100, r111);
        k2 r102 = k2.f365755a;
        g3.a.a(this.f291229a, null, false, null, false, new c(r101), 30);
    }

    public DigitalAvatarUploadActionDelegate(Fragment r100, LifecycleCoroutineScope r101, s r102, DigitalAvatarUploadViewModel r103, DigitalAvatarPreGenManager r104, r r105, Function0<a> r106, Function0<Unit> r107) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "lifecycleScope");
        Intrinsics.checkNotNullParameter(r102, "uiState");
        Intrinsics.checkNotNullParameter(r103, "viewModel");
        Intrinsics.checkNotNullParameter(r104, "preGenManager");
        Intrinsics.checkNotNullParameter(r105, com.bytedance.android.ec.core.event.a.KEY_TRACKER);
        Intrinsics.checkNotNullParameter(r106, "actionContextProvider");
        Intrinsics.checkNotNullParameter(r107, "onStateChanged");
        this.f291229a = r100;
        this.f291230b = r101;
        this.f291231c = r102;
        this.f291232d = r103;
        this.f291233e = r104;
        this.f291234f = r105;
        this.f291235g = r106;
        this.f291236h = r107;
        this.f291239k = 1000;
    }
}
