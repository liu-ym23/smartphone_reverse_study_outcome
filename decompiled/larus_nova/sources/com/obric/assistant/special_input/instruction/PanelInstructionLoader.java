package com.obric.assistant.special_input.instruction;

import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ComplexTaskCaseFromPCConfig;
import com.obric.assistant.settings.ObricAppListMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes33.dex */
public final class PanelInstructionLoader {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy<Gson> f392731i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<ComplexTaskCaseFromPCConfig> f392732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<PanelInstructionItem> f392733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<PanelInstructionItem> f392734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<PanelInstructionItem> f392735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.obric.assistant.settings.d f392736e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<PanelInstructionItem> f392737f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f392738g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CoroutineScope f392739h;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f392740a = null;

        static {
            int[] r100 = new int[ObricAppListMode.values().length];
            r100[ObricAppListMode.BLACK_LIST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ObricAppListMode.WHITE_LIST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f392740a = r100;
        }
    }

    public PanelInstructionLoader() {
        this(null);
    }

    static {
        f392731i = LazyKt.lazy(new c());
    }

    public PanelInstructionLoader(Object r100) {
        Function0<ComplexTaskCaseFromPCConfig> r101 = new com.obric.assistant.special_input.instruction.a();
        Intrinsics.checkNotNullParameter(r101, "configProvider");
        this.f392732a = r101;
        this.f392733b = CollectionsKt.emptyList();
        this.f392734c = CollectionsKt.emptyList();
        this.f392735d = CollectionsKt.emptyList();
        this.f392736e = new com.obric.assistant.settings.d(0);
        this.f392737f = d(((ComplexTaskCaseFromPCConfig) r101.invoke()).getLocalLimitCount());
        this.f392739h = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public static List d(int r110) {
        List r100 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(R.string.obric_phone_operation_pro_default_instruction1), Integer.valueOf(R.string.obric_phone_operation_pro_default_instruction2), Integer.valueOf(R.string.obric_phone_operation_pro_default_instruction3), Integer.valueOf(R.string.obric_phone_operation_pro_default_instruction4), Integer.valueOf(R.string.obric_phone_operation_pro_default_instruction5), Integer.valueOf(R.string.obric_phone_operation_pro_default_instruction6), Integer.valueOf(R.string.obric_phone_operation_pro_default_instruction7), Integer.valueOf(R.string.obric_phone_operation_pro_default_instruction8), Integer.valueOf(R.string.obric_phone_operation_pro_default_instruction9), Integer.valueOf(R.string.obric_phone_operation_pro_default_instruction10), Integer.valueOf(R.string.obric_phone_operation_pro_default_instruction11), Integer.valueOf(R.string.obric_phone_operation_pro_default_instruction12), Integer.valueOf(R.string.obric_phone_operation_pro_default_instruction13)});
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L17;
        int r103 = ((Number) r102.next()).intValue();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
        Object r105 = Result.m9449constructorimpl(AppHost.f326268a.getApplication().getString(r103));     // Catch: Throwable -> L8
    L10:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L14;
        FLogger.f375446a.i("PanelInstructionLoader", "get default instruction failed: " + r103 + ", " + r106.getMessage());
    L14:
        if (Result.m9455isFailureimpl(r105) == false) goto L16;
        r105 = "";
    L16:
        r101.add((String) r105);
    L8:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L17:
        ArrayList r108 = new ArrayList();
        Iterator r109 = r101.iterator();
    L19:
        if (r109.hasNext() == false) goto L29;
        String r111 = (String) r109.next();
        PanelInstructionItem r112 = null;
        if ((!StringsKt.isBlank(r111)) == false) goto L23;
        String r113 = r111;
    L24:
        if (r113 == null) goto L26;
        r112 = new PanelInstructionItem(null, r113, r113, PanelInstructionType.RECOMMEND_LOCAL, null, null, 0, 113, null);
    L26:
        if (r112 == null) goto L19;
        r108.add(r112);
        goto L19
    L23:
        r113 = null;
        goto L24
    L29:
        return CollectionsKt.take(r108, r110);
    }

    public static e g(String r100) {
        e r101 = null;
        if (StringsKt.isBlank(r100) == false) goto L28;
        return null;
    L28:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        Object r103 = Result.m9449constructorimpl((e) f392731i.getValue().fromJson(r100, e.class));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r103) == false) goto L12;
        r103 = null;
    L12:
        e r104 = (e) r103;
        if (r104 == null) goto L27;
        String r105 = r104.a();
        if (r105 != null) goto L17;
    L20:
        boolean r106 = true;
    L22:
        if ((!r106) == false) goto L24;
        r101 = r104;
    L24:
        if (r101 == null) goto L27;
        return r101;
    L17:
        if (StringsKt.isBlank(r105) == true) goto L20;
        r106 = false;
    L27:
        return new e(r100, 6);
    L7:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final List<PanelInstructionItem> a(ComplexTaskCaseFromPCConfig r210) {
        List r100 = CollectionsKt.plus(CollectionsKt.plus(this.f392733b, this.f392734c), this.f392735d);
        HashSet r101 = new HashSet();
        ArrayList r102 = new ArrayList();
        Iterator r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        PanelInstructionItem r105 = (PanelInstructionItem) r104;
        if (r101.add(TuplesKt.to(r105.getType(), r105.getDisplayText())) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        ArrayList r106 = new ArrayList();
        Iterator r107 = r102.iterator();
    L9:
        boolean r108 = true;
        if (r107.hasNext() == false) goto L30;
        Object r109 = r107.next();
        PanelInstructionItem r110 = (PanelInstructionItem) r109;
        com.obric.assistant.settings.d r111 = this.f392736e;
        if (c(r110, r111.f392016d) == false) goto L15;
    L27:
        r108 = false;
    L28:
        if (r108 == false) goto L9;
        r106.add(r109);
        goto L9
    L15:
        if (c(r110, r111.f392017e) == true) goto L28;
        int r112 = b.f392740a[r111.f392013a.ordinal()];
        if (r112 == 1) goto L25;
        if (r112 != 2) goto L23;
        r108 = c(r110, r111.f392015c);
        goto L28
    L23:
        throw new NoWhenBranchMatchedException();
    L25:
        if (c(r110, r111.f392014b) == true) goto L27;
    L30:
        ArrayList r113 = new ArrayList();
        Iterator r114 = r106.iterator();
    L32:
        if (r114.hasNext() == false) goto L48;
        PanelInstructionItem r115 = (PanelInstructionItem) r114.next();
        int r116 = r210.getMaxTextLength();
        if (StringsKt.isBlank(r115.getDisplayText()) == false) goto L36;
    L45:
        PanelInstructionItem r117 = null;
    L46:
        if (r117 == null) goto L32;
        r113.add(r117);
        goto L32
    L36:
        if (StringsKt.isBlank(r115.getSendText()) == true) goto L45;
        String r118 = StringsKt.replace$default(StringsKt.replace$default(r115.getDisplayText(), "\r", " ", false, 4, null), "\n", " ", false, 4, null);
        if (r116 > 0) goto L41;
    L44:
        r117 = PanelInstructionItem.copy$default(r115, null, r118, null, null, null, null, 0, 125, null);
        goto L46
    L41:
        if (r118.length() <= r116) goto L44;
        r117 = PanelInstructionItem.copy$default(r115, null, StringsKt.take(r118, RangesKt.coerceAtLeast(r116 - 1, 1)) + 8230, null, null, null, null, 0, 125, null);
        goto L46
    L48:
        return r113;
    }

    public final Object b(Continuation<? super d> r100) {
        if ((r100 instanceof PanelInstructionLoader$getRefreshedPanelItems$1) == false) goto L7;
        PanelInstructionLoader$getRefreshedPanelItems$1 r101 = (PanelInstructionLoader$getRefreshedPanelItems$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ComplexTaskCaseFromPCConfig r106 = (ComplexTaskCaseFromPCConfig) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L21:
        List<PanelInstructionItem> r107 = (List) r103;
        boolean r108 = !Intrinsics.areEqual(this.f392733b, r107);
        if (r108 == false) goto L24;
        this.f392733b = r107;
    L24:
        List<PanelInstructionItem> r109 = a(r106);
        this.f392737f = r109;
        return new d(r108, r109);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        ComplexTaskCaseFromPCConfig r110 = this.f392732a.invoke();
        int r111 = r110.getShortcutLimitCount();
        r101.L$0 = r110;
        r101.label = 1;
        if (r111 > 0) goto L17;
        Object r112 = CollectionsKt.emptyList();
    L18:
        if (r112 != r104) goto L20;
        return r104;
    L20:
        Object r113 = r112;
        r106 = r110;
        r103 = r113;
        goto L21
    L17:
        r112 = BuildersKt.withContext(Dispatchers.getIO(), new PanelInstructionLoader$loadShortcutItems$2(r111, this, null), r101);
    L7:
        r101 = new PanelInstructionLoader$getRefreshedPanelItems$1(this, r100);
        goto L8
    }

    public final Object e(Continuation<? super List<PanelInstructionItem>> r100) {
        return CoroutineScopeKt.coroutineScope(new PanelInstructionLoader$loadPanelItems$2(this, null), r100);
    }

    public static boolean c(PanelInstructionItem r100, Set r101) {
        if (r101.isEmpty() == false) goto L5;
        return false;
    L5:
        Set r102 = r101;
        if ((r102 instanceof Collection) == true) goto L8;
    L10:
        Iterator r103 = r102.iterator();
    L12:
        if (r103.hasNext() == false) goto L34;
        String r104 = (String) r103.next();
        if ((!StringsKt.isBlank(r104)) == true) goto L16;
    L24:
        boolean r105 = false;
    L25:
        if (r105 == false) goto L12;
        return true;
    L16:
        if (StringsKt.contains$default(r100.getDisplayText(), r104, false, 2, null) == false) goto L18;
    L21:
        boolean r106 = true;
    L22:
        if (r106 == false) goto L24;
        r105 = true;
        goto L25
    L18:
        if (StringsKt.contains$default(r100.getSendText(), r104, false, 2, null) == true) goto L21;
        r106 = false;
        goto L22
    L34:
        return false;
    L8:
        if (r102.isEmpty() == false) goto L10;
        return false;
    }

    public static PanelInstructionItem f(e r110, PanelInstructionType r111) {
        String r100 = r110.a();
        if (r100 != null) goto L5;
    L12:
        return null;
    L5:
        if ((!StringsKt.isBlank(r100)) == false) goto L7;
        String r101 = r100;
    L8:
        if (r101 == null) goto L12;
        return new PanelInstructionItem(null, r101, r101, r111, r110.b(), r110.c(), 0, 65, null);
    L7:
        r101 = null;
        goto L8
    }
}
