package com.bytedance.lark.base.open.pkm;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/lark/base/open/pkm/PkmPrepareStep;", "", "(Ljava/lang/String;I)V", "into", "Lopen_pkm/proto/PkmPrepareStep;", "intoInt", "", "LoadMetaStart", "LoadMetaProgress", "LoadMetaComplete", "LoadPkgStart", "LoadPkgProgress", "LoadPkgReady", "LoadPkgComplete", "MetaFailed", "PkgFailed", "Success", "Companion", "open_pkm_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum PkmPrepareStep extends Enum<PkmPrepareStep> {
    public static final a Companion = null;
    public static final PkmPrepareStep LoadMetaComplete = null;
    public static final PkmPrepareStep LoadMetaProgress = null;
    public static final PkmPrepareStep LoadMetaStart = null;
    public static final PkmPrepareStep LoadPkgComplete = null;
    public static final PkmPrepareStep LoadPkgProgress = null;
    public static final PkmPrepareStep LoadPkgReady = null;
    public static final PkmPrepareStep LoadPkgStart = null;
    public static final PkmPrepareStep MetaFailed = null;
    public static final PkmPrepareStep PkgFailed = null;
    public static final PkmPrepareStep Success = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PkmPrepareStep[] f252884a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f252885b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f252886a = null;

        static {
            int[] r100 = new int[PkmPrepareStep.values().length];
            r100[PkmPrepareStep.LoadMetaStart.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r100[PkmPrepareStep.LoadMetaProgress.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r100[PkmPrepareStep.LoadMetaComplete.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[PkmPrepareStep.LoadPkgStart.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r100[PkmPrepareStep.LoadPkgProgress.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r100[PkmPrepareStep.LoadPkgReady.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r100[PkmPrepareStep.LoadPkgComplete.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r100[PkmPrepareStep.MetaFailed.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r100[PkmPrepareStep.PkgFailed.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r100[PkmPrepareStep.Success.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            f252886a = r100;
        }
    }

    public static EnumEntries<PkmPrepareStep> getEntries() {
        return f252885b;
    }

    public static PkmPrepareStep valueOf(String r100) {
        return (PkmPrepareStep) r27.a.a(PkmPrepareStep.class, r100);
    }

    public static PkmPrepareStep[] values() {
        return (PkmPrepareStep[]) f252884a.clone();
    }

    static {
        PkmPrepareStep r100 = new PkmPrepareStep("LoadMetaStart", 0);
        LoadMetaStart = r100;
        PkmPrepareStep r101 = new PkmPrepareStep("LoadMetaProgress", 1);
        LoadMetaProgress = r101;
        PkmPrepareStep r102 = new PkmPrepareStep("LoadMetaComplete", 2);
        LoadMetaComplete = r102;
        PkmPrepareStep r103 = new PkmPrepareStep("LoadPkgStart", 3);
        LoadPkgStart = r103;
        PkmPrepareStep r104 = new PkmPrepareStep("LoadPkgProgress", 4);
        LoadPkgProgress = r104;
        PkmPrepareStep r105 = new PkmPrepareStep("LoadPkgReady", 5);
        LoadPkgReady = r105;
        PkmPrepareStep r110 = new PkmPrepareStep("LoadPkgComplete", 6);
        LoadPkgComplete = r110;
        PkmPrepareStep r111 = new PkmPrepareStep("MetaFailed", 7);
        MetaFailed = r111;
        PkmPrepareStep r112 = new PkmPrepareStep("PkgFailed", 8);
        PkgFailed = r112;
        PkmPrepareStep r113 = new PkmPrepareStep("Success", 9);
        Success = r113;
        PkmPrepareStep[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f252884a = r114;
        f252885b = EnumEntriesKt.enumEntries(r114);
        Companion = new a();
    }

    public final open_pkm.proto.PkmPrepareStep into() {
        switch(b.f252886a[ordinal()]) {
            case 1: goto L16;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L17;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L17:
        return open_pkm.proto.PkmPrepareStep.VAR_PKM_PREPARE_STEP_SUCCESS;
    L18:
        return open_pkm.proto.PkmPrepareStep.VAR_PKM_PREPARE_STEP_PKG_FAILED;
    L19:
        return open_pkm.proto.PkmPrepareStep.VAR_PKM_PREPARE_STEP_META_FAILED;
    L20:
        return open_pkm.proto.PkmPrepareStep.VAR_PKM_PREPARE_STEP_LOAD_PKG_COMPLETE;
    L21:
        return open_pkm.proto.PkmPrepareStep.VAR_PKM_PREPARE_STEP_LOAD_PKG_READY;
    L22:
        return open_pkm.proto.PkmPrepareStep.VAR_PKM_PREPARE_STEP_LOAD_PKG_PROGRESS;
    L23:
        return open_pkm.proto.PkmPrepareStep.VAR_PKM_PREPARE_STEP_LOAD_PKG_START;
    L24:
        return open_pkm.proto.PkmPrepareStep.VAR_PKM_PREPARE_STEP_LOAD_META_COMPLETE;
    L25:
        return open_pkm.proto.PkmPrepareStep.VAR_PKM_PREPARE_STEP_LOAD_META_PROGRESS;
    L16:
        return open_pkm.proto.PkmPrepareStep.VAR_PKM_PREPARE_STEP_LOAD_META_START;
    }

    public final int intoInt() {
        switch(b.f252886a[ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            default: goto L5;
        };
    L6:
        return 9;
    L7:
        return 8;
    L8:
        return 7;
    L9:
        return 6;
    L10:
        return 5;
    L11:
        return 4;
    L12:
        return 3;
    L13:
        return 2;
    L14:
        return 1;
    L15:
        return 0;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final PkmPrepareStep fromInt(int r100) {
        Companion.getClass();
        switch(r100) {
            case 0: goto L16;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            default: goto L5;
        };
    L5:
        throw new RuntimeException("Unmatched primitive enum value: PkmPrepareStep with ");
    L17:
        return Success;
    L18:
        return PkgFailed;
    L19:
        return MetaFailed;
    L20:
        return LoadPkgComplete;
    L21:
        return LoadPkgReady;
    L22:
        return LoadPkgProgress;
    L23:
        return LoadPkgStart;
    L24:
        return LoadMetaComplete;
    L25:
        return LoadMetaProgress;
    L16:
        return LoadMetaStart;
    }

    public PkmPrepareStep(String r100, int r101) {
        super(r100, r101);
    }
}
