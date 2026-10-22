package zl9;

import com.larus.navigation.api.kmp.KmpInstructionActionType;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f572804a = 0;

    /* JADX INFO: renamed from: zl9.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C8474a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f572805a = null;

        static {
            int[] r100 = new int[KmpInstructionActionType.values().length];
            r100[KmpInstructionActionType.UTURN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L35:
            r100[KmpInstructionActionType.SHARP_RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L51:
            r100[KmpInstructionActionType.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L39:
            r100[KmpInstructionActionType.SLIGHT_RIGHT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L43:
            r100[KmpInstructionActionType.STRAIGHT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L29:
            r100[KmpInstructionActionType.SLIGHT_LEFT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L45:
            r100[KmpInstructionActionType.LEFT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L47:
            r100[KmpInstructionActionType.SHARP_LEFT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L37:
            r100[KmpInstructionActionType.ARRIVE_VIA.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L41:
            r100[KmpInstructionActionType.ARRIVE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L31:
            r100[KmpInstructionActionType.ARRIVED.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L33:
            r100[KmpInstructionActionType.MOVE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L15:
            f572805a = r100;
        }
    }

    static {
    }
}
