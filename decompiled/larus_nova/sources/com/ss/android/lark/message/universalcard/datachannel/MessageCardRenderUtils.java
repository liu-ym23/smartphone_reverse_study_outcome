package com.ss.android.lark.message.universalcard.datachannel;

import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class MessageCardRenderUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f432239a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/message/universalcard/datachannel/MessageCardRenderUtils$StreamingBindViewMethod;", "", "<init>", "(Ljava/lang/String;I)V", "UPDATE_AND_RENDER", "UPDATE_ONLY", "message-card_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum StreamingBindViewMethod extends Enum<StreamingBindViewMethod> {
        public static final StreamingBindViewMethod UPDATE_AND_RENDER = null;
        public static final StreamingBindViewMethod UPDATE_ONLY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StreamingBindViewMethod[] f432240a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f432241b = null;

        public static EnumEntries<StreamingBindViewMethod> getEntries() {
            return f432241b;
        }

        static {
            StreamingBindViewMethod r100 = new StreamingBindViewMethod("UPDATE_AND_RENDER", 0);
            UPDATE_AND_RENDER = r100;
            StreamingBindViewMethod r101 = new StreamingBindViewMethod("UPDATE_ONLY", 1);
            UPDATE_ONLY = r101;
            StreamingBindViewMethod[] r102 = {r100, r101};
            f432240a = r102;
            f432241b = EnumEntriesKt.enumEntries(r102);
        }

        public static StreamingBindViewMethod[] values() {
            return (StreamingBindViewMethod[]) f432240a.clone();
        }

        public static StreamingBindViewMethod valueOf(String r100) {
            return (StreamingBindViewMethod) r27.a.a(StreamingBindViewMethod.class, r100);
        }

        public StreamingBindViewMethod(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
    }

    public static boolean a(LynxCardContentVO r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return ((CardContent) r100.f553338a).isStreamingMode();
    }
}
