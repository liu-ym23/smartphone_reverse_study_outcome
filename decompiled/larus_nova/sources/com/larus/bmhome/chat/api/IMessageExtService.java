package com.larus.bmhome.chat.api;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\rJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J4\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH&J4\u0010\f\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/api/IMessageExtService;", "", "service", "", "setSendMessageExt", "", "map", "", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "metadata", "Lcom/larus/bmhome/chat/api/IMessageExtService$QueryData;", "handleReeditMessageExt", "QueryData", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMessageExtService {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f297167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f297168b;

        public a() {
            this(null, 3);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f297167a, r101.f297167a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f297168b, r101.f297168b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f297167a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f297168b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "QueryData(content=" + this.f297167a + ", messageId=" + this.f297168b + ')';
        }

        public /* synthetic */ a(String r100, int r101) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100, null);
        }

        public a(String r100, String r101) {
            this.f297167a = r100;
            this.f297168b = r101;
        }
    }

    void a(Map<String, String> r100, wc9.e r101, a r102);

    void b(Map r100, a r101);

    String service();
}
