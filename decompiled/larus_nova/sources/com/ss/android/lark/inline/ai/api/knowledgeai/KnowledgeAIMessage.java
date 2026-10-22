package com.ss.android.lark.inline.ai.api.knowledgeai;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004\u000e\u000f\u0010\u0011B\u001d\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f\u0082\u0001\u0004\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/IKnowledgeAIMessage;", "type", "", "data", "<init>", "(Ljava/lang/String;Ljava/io/Serializable;)V", "getType", "()Ljava/lang/String;", "getData", "()Ljava/io/Serializable;", "Ljava/io/Serializable;", "OpenUrlMessage", "InsertToDocsMessage", "ClosePanelMessage", "OpenPanelMessage", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage$ClosePanelMessage;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage$InsertToDocsMessage;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage$OpenPanelMessage;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage$OpenUrlMessage;", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class KnowledgeAIMessage<T extends Serializable> implements Serializable, IKnowledgeAIMessage<T> {
    private final T data;
    private final String type;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0002HÖ\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage$ClosePanelMessage;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage;", "", "data", "<init>", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ClosePanelMessage extends KnowledgeAIMessage<String> {
        private final String data;

        /* JADX WARN: Multi-variable type inference failed */
        public ClosePanelMessage() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ClosePanelMessage copy$default(ClosePanelMessage r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.data;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.data;
        }

        public final ClosePanelMessage copy(String r100) {
            return new ClosePanelMessage(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ClosePanelMessage) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.data, ((ClosePanelMessage) r100).data) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            String r100 = this.data;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public String toString() {
            return "ClosePanelMessage(data=" + this.data + ')';
        }

        @Override // com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIMessage, com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIMessage
        public /* bridge */ /* synthetic */ Serializable getData() {
            return getData();
        }

        @Override // com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIMessage, com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIMessage
        public String getData() {
            return this.data;
        }

        public ClosePanelMessage(String r100) {
            super("closePanel", r100, null);
            this.data = r100;
        }

        public /* synthetic */ ClosePanelMessage(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage$InsertToDocsMessage;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage;", "", "data", "<init>", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InsertToDocsMessage extends KnowledgeAIMessage<String> {
        private final String data;

        public static /* synthetic */ InsertToDocsMessage copy$default(InsertToDocsMessage r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.data;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.data;
        }

        public final InsertToDocsMessage copy(String r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            return new InsertToDocsMessage(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof InsertToDocsMessage) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.data, ((InsertToDocsMessage) r100).data) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "InsertToDocsMessage(data=" + this.data + ')';
        }

        @Override // com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIMessage, com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIMessage
        public /* bridge */ /* synthetic */ Serializable getData() {
            return getData();
        }

        @Override // com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIMessage, com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIMessage
        public String getData() {
            return this.data;
        }

        public InsertToDocsMessage(String r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            super("insertToDocs", r100, null);
            this.data = r100;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0002HÖ\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage$OpenPanelMessage;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage;", "", "data", "<init>", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OpenPanelMessage extends KnowledgeAIMessage<String> {
        private final String data;

        /* JADX WARN: Multi-variable type inference failed */
        public OpenPanelMessage() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ OpenPanelMessage copy$default(OpenPanelMessage r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.data;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.data;
        }

        public final OpenPanelMessage copy(String r100) {
            return new OpenPanelMessage(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof OpenPanelMessage) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.data, ((OpenPanelMessage) r100).data) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            String r100 = this.data;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public String toString() {
            return "OpenPanelMessage(data=" + this.data + ')';
        }

        @Override // com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIMessage, com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIMessage
        public /* bridge */ /* synthetic */ Serializable getData() {
            return getData();
        }

        @Override // com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIMessage, com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIMessage
        public String getData() {
            return this.data;
        }

        public OpenPanelMessage(String r100) {
            super("openPanel", r100, null);
            this.data = r100;
        }

        public /* synthetic */ OpenPanelMessage(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage$OpenUrlMessage;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/UrlData;", "data", "<init>", "(Lcom/ss/android/lark/inline/ai/api/knowledgeai/UrlData;)V", "getData", "()Lcom/ss/android/lark/inline/ai/api/knowledgeai/UrlData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OpenUrlMessage extends KnowledgeAIMessage<UrlData> {
        private final UrlData data;

        public static /* synthetic */ OpenUrlMessage copy$default(OpenUrlMessage r100, UrlData r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.data;
        L6:
            return r100.copy(r101);
        }

        public final UrlData component1() {
            return this.data;
        }

        public final OpenUrlMessage copy(UrlData r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            return new OpenUrlMessage(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof OpenUrlMessage) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.data, ((OpenUrlMessage) r100).data) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "OpenUrlMessage(data=" + this.data + ')';
        }

        @Override // com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIMessage, com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIMessage
        public /* bridge */ /* synthetic */ Serializable getData() {
            return getData();
        }

        @Override // com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIMessage, com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIMessage
        public UrlData getData() {
            return this.data;
        }

        public OpenUrlMessage(UrlData r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            super(RuleConditionBean.OPEN_URL_KEY, r100, null);
            this.data = r100;
        }
    }

    public KnowledgeAIMessage() {
        throw null;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIMessage
    public T getData() {
        return this.data;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIMessage
    public String getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KnowledgeAIMessage(String r100, Serializable r101, DefaultConstructorMarker r102) {
        this.type = r100;
        this.data = r101;
    }

    public /* synthetic */ KnowledgeAIMessage(String r100, Serializable r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, null);
    }
}
