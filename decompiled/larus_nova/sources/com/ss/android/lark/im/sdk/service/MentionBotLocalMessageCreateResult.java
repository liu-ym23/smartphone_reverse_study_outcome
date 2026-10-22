package com.ss.android.lark.im.sdk.service;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
public abstract class MentionBotLocalMessageCreateResult {

    public static final class Failure extends MentionBotLocalMessageCreateResult {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/im/sdk/service/MentionBotLocalMessageCreateResult$Failure$Reason;", "", "<init>", "(Ljava/lang/String;I)V", "SOURCE_NOT_READY", "DB_ERROR", "PUSH_ERROR", "UNSUPPORTED", FlowDoraWifiScene.OTHER, "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Reason extends Enum<Reason> {
            public static final Reason DB_ERROR = null;
            public static final Reason OTHER = null;
            public static final Reason PUSH_ERROR = null;
            public static final Reason SOURCE_NOT_READY = null;
            public static final Reason UNSUPPORTED = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Reason[] f426056a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f426057b = null;

            public static EnumEntries<Reason> getEntries() {
                return f426057b;
            }

            static {
                Reason r100 = new Reason("SOURCE_NOT_READY", 0);
                SOURCE_NOT_READY = r100;
                Reason r101 = new Reason("DB_ERROR", 1);
                DB_ERROR = r101;
                Reason r102 = new Reason("PUSH_ERROR", 2);
                PUSH_ERROR = r102;
                Reason r103 = new Reason("UNSUPPORTED", 3);
                UNSUPPORTED = r103;
                Reason r104 = new Reason(FlowDoraWifiScene.OTHER, 4);
                OTHER = r104;
                Reason[] r105 = {r100, r101, r102, r103, r104};
                f426056a = r105;
                f426057b = EnumEntriesKt.enumEntries(r105);
            }

            public static Reason[] values() {
                return (Reason[]) f426056a.clone();
            }

            public static Reason valueOf(String r100) {
                return (Reason) r27.a.a(Reason.class, r100);
            }

            public Reason(String r100, int r101) {
                super(r100, r101);
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Failure) == true) goto L9;
            return false;
        L9:
            ((Failure) r100).getClass();
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Failure(reason=null)";
        }
    }

    public static final class a extends MentionBotLocalMessageCreateResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f426058a = null;

        static {
            f426058a = new a();
        }

        public a() {
        }
    }

    public MentionBotLocalMessageCreateResult() {
    }
}
