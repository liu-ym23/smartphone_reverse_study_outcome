package com.larus.dora.impl.dynamic.dsl;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
public final class DslActorFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f335157a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/dynamic/dsl/DslActorFactory$ToastType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SUCCESS", "WARNING", "FAILURE", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ToastType extends Enum<ToastType> {
        public static final a Companion = null;
        public static final ToastType FAILURE = null;
        public static final ToastType SUCCESS = null;
        public static final ToastType WARNING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ToastType[] f335158a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f335159b = null;
        private final String value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<ToastType> getEntries() {
            return f335159b;
        }

        static {
            ToastType r100 = new ToastType("SUCCESS", 0, "success");
            SUCCESS = r100;
            ToastType r101 = new ToastType("WARNING", 1, "warning");
            WARNING = r101;
            ToastType r102 = new ToastType("FAILURE", 2, "failure");
            FAILURE = r102;
            ToastType[] r103 = {r100, r101, r102};
            f335158a = r103;
            f335159b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static ToastType[] values() {
            return (ToastType[]) f335158a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static ToastType valueOf(String r100) {
            return (ToastType) r27.a.a(ToastType.class, r100);
        }

        public ToastType(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f335160a = null;

        static {
            int[] r100 = new int[DslActionType.values().length];
            r100[DslActionType.EXTERNAL_JUMP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[DslActionType.EXTERNAL_JUMP_BY_EXPLICIT_INTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[DslActionType.WEB_JUMP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[DslActionType.TOAST.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f335160a = r100;
        }
    }

    static {
    }
}
