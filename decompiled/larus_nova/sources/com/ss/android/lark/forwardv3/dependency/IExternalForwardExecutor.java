package com.ss.android.lark.forwardv3.dependency;

import android.content.Context;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes36.dex */
public interface IExternalForwardExecutor {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/forwardv3/dependency/IExternalForwardExecutor$ExternalForwardFailureReason;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "MESSAGE_CONTENT_TOO_LARGE", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ExternalForwardFailureReason extends Enum<ExternalForwardFailureReason> {
        public static final ExternalForwardFailureReason MESSAGE_CONTENT_TOO_LARGE = null;
        public static final ExternalForwardFailureReason UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ExternalForwardFailureReason[] f425331a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f425332b = null;

        public static EnumEntries<ExternalForwardFailureReason> getEntries() {
            return f425332b;
        }

        static {
            ExternalForwardFailureReason r100 = new ExternalForwardFailureReason("UNKNOWN", 0);
            UNKNOWN = r100;
            ExternalForwardFailureReason r101 = new ExternalForwardFailureReason("MESSAGE_CONTENT_TOO_LARGE", 1);
            MESSAGE_CONTENT_TOO_LARGE = r101;
            ExternalForwardFailureReason[] r102 = {r100, r101};
            f425331a = r102;
            f425332b = EnumEntriesKt.enumEntries(r102);
        }

        public static ExternalForwardFailureReason[] values() {
            return (ExternalForwardFailureReason[]) f425331a.clone();
        }

        public static ExternalForwardFailureReason valueOf(String r100) {
            return (ExternalForwardFailureReason) r27.a.a(ExternalForwardFailureReason.class, r100);
        }

        public ExternalForwardFailureReason(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void onFailure(String r100);

        void onSuccess(Map<String, ? extends ForwardTargetBaseInfoNew> r100);
    }

    void a(CoroutineScope r100, Context r101, List<? extends SearchBaseInfo> r102, String r103, RichText r104, a r105);
}
