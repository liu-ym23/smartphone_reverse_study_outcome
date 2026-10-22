package com.ss.android.lark.intent.export.entity.output;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.intent.export.entity.output.common.CommonSuccessAsyncIntentOutput;
import com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import knb.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/QueryKnowledgeAIIntentOutput;", "", "<init>", "()V", "QueryKnowledgeAIIntentSyncOutput", "QueryKnowledgeAIIntentAsyncOutput", "Reference", "OpenUrlLinkOutput", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QueryKnowledgeAIIntentOutput {
    public static final QueryKnowledgeAIIntentOutput INSTANCE = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/QueryKnowledgeAIIntentOutput$OpenUrlLinkOutput;", "Lcom/ss/android/lark/intent/export/entity/output/common/CommonSuccessIntentOutput;", "url", "", "display", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getDisplay", "toString", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OpenUrlLinkOutput extends CommonSuccessIntentOutput {
        public static final Parcelable.Creator<OpenUrlLinkOutput> CREATOR = null;
        private final String display;
        private final String url;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<OpenUrlLinkOutput> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final OpenUrlLinkOutput createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                return new OpenUrlLinkOutput(r100.readString(), r100.readString());
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ OpenUrlLinkOutput createFromParcel(Parcel r100) {
                return createFromParcel(r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final OpenUrlLinkOutput[] newArray(int r100) {
                return new OpenUrlLinkOutput[r100];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ OpenUrlLinkOutput[] newArray(int r100) {
                return newArray(r100);
            }
        }

        static {
            CREATOR = new Creator();
        }

        @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "dest");
            r100.writeString(this.url);
            r100.writeString(this.display);
        }

        public String toString() {
            return "OpenUrlLinkOutput(url='" + a.a(this.url) + "')";
        }

        public final String getDisplay() {
            return this.display;
        }

        public final String getUrl() {
            return this.url;
        }

        public OpenUrlLinkOutput(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "url");
            super(Direction.WEB_URL, r101);
            this.url = r100;
            this.display = r101;
        }

        public /* synthetic */ OpenUrlLinkOutput(String r100, String r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = null;
        L5:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BI\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/QueryKnowledgeAIIntentOutput$QueryKnowledgeAIIntentAsyncOutput;", "Lcom/ss/android/lark/intent/export/entity/output/common/CommonSuccessAsyncIntentOutput;", "topicId", "", "markdown", "appLink", "references", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/intent/export/entity/output/QueryKnowledgeAIIntentOutput$Reference;", "Lkotlin/collections/ArrayList;", "display", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "getTopicId", "()Ljava/lang/String;", "getMarkdown", "getAppLink", "getReferences", "()Ljava/util/ArrayList;", "getDisplay", "toString", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class QueryKnowledgeAIIntentAsyncOutput extends CommonSuccessAsyncIntentOutput {
        public static final Parcelable.Creator<QueryKnowledgeAIIntentAsyncOutput> CREATOR = null;
        private final String appLink;
        private final String display;
        private final String markdown;
        private final ArrayList<Reference> references;
        private final String topicId;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<QueryKnowledgeAIIntentAsyncOutput> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final QueryKnowledgeAIIntentAsyncOutput createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                String r101 = r100.readString();
                String r102 = r100.readString();
                String r103 = r100.readString();
                int r104 = r100.readInt();
                ArrayList r105 = new ArrayList(r104);
                int r106 = 0;
            L3:
                if (r106 == r104) goto L6;
                r105.add(Reference.CREATOR.createFromParcel(r100));
                r106 = r106 + 1;
                goto L3
            L6:
                return new QueryKnowledgeAIIntentAsyncOutput(r101, r102, r103, r105, r100.readString());
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ QueryKnowledgeAIIntentAsyncOutput createFromParcel(Parcel r100) {
                return createFromParcel(r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final QueryKnowledgeAIIntentAsyncOutput[] newArray(int r100) {
                return new QueryKnowledgeAIIntentAsyncOutput[r100];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ QueryKnowledgeAIIntentAsyncOutput[] newArray(int r100) {
                return newArray(r100);
            }
        }

        static {
            CREATOR = new Creator();
        }

        @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessAsyncIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessAsyncIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "dest");
            r100.writeString(this.topicId);
            r100.writeString(this.markdown);
            r100.writeString(this.appLink);
            ArrayList<Reference> r102 = this.references;
            r100.writeInt(r102.size());
            Iterator<Reference> r103 = r102.iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            r103.next().writeToParcel(r100, r101);
            goto L4
        L6:
            r100.writeString(this.display);
        }

        public String toString() {
            StringBuilder r100 = new StringBuilder("QueryKnowledgeAIIntentAsyncOutput(topicId='");
            r100.append(this.topicId);
            r100.append("', markdown=");
            String r101 = this.markdown;
            if (r101 == null) goto L5;
            String r102 = a.a(r101);
        L6:
            r100.append(r102);
            r100.append(", appLink='");
            r100.append(this.appLink);
            r100.append("', references=");
            r100.append(this.references);
            r100.append(')');
            return r100.toString();
        L5:
            r102 = null;
            goto L6
        }

        public final String getAppLink() {
            return this.appLink;
        }

        public final String getDisplay() {
            return this.display;
        }

        public final String getMarkdown() {
            return this.markdown;
        }

        public final ArrayList<Reference> getReferences() {
            return this.references;
        }

        public final String getTopicId() {
            return this.topicId;
        }

        public QueryKnowledgeAIIntentAsyncOutput(String r100, String r101, String r102, ArrayList<Reference> r103, String r104) {
            Intrinsics.checkNotNullParameter(r103, "references");
            super(Direction.QUERY_KNOWLEDGE_AI_ASYNC, r104);
            this.topicId = r100;
            this.markdown = r101;
            this.appLink = r102;
            this.references = r103;
            this.display = r104;
        }

        public /* synthetic */ QueryKnowledgeAIIntentAsyncOutput(String r100, String r101, String r102, ArrayList r110, String r111, int r112, DefaultConstructorMarker r113) {
            if ((r112 & 16) == 0) goto L5;
            r111 = null;
        L5:
            this(r100, r101, r102, r110, r111);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/QueryKnowledgeAIIntentOutput$QueryKnowledgeAIIntentSyncOutput;", "Lcom/ss/android/lark/intent/export/entity/output/common/CommonSuccessIntentOutput;", "topicId", "", "display", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTopicId", "()Ljava/lang/String;", "getDisplay", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class QueryKnowledgeAIIntentSyncOutput extends CommonSuccessIntentOutput {
        public static final Parcelable.Creator<QueryKnowledgeAIIntentSyncOutput> CREATOR = null;
        private final String display;
        private final String topicId;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<QueryKnowledgeAIIntentSyncOutput> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final QueryKnowledgeAIIntentSyncOutput createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                return new QueryKnowledgeAIIntentSyncOutput(r100.readString(), r100.readString());
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ QueryKnowledgeAIIntentSyncOutput createFromParcel(Parcel r100) {
                return createFromParcel(r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final QueryKnowledgeAIIntentSyncOutput[] newArray(int r100) {
                return new QueryKnowledgeAIIntentSyncOutput[r100];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ QueryKnowledgeAIIntentSyncOutput[] newArray(int r100) {
                return newArray(r100);
            }
        }

        static {
            CREATOR = new Creator();
        }

        @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "dest");
            r100.writeString(this.topicId);
            r100.writeString(this.display);
        }

        public final String getDisplay() {
            return this.display;
        }

        public final String getTopicId() {
            return this.topicId;
        }

        public QueryKnowledgeAIIntentSyncOutput(String r100, String r101) {
            super(Direction.QUERY_KNOWLEDGE_AI_SYNC, r101);
            this.topicId = r100;
            this.display = r101;
        }

        public /* synthetic */ QueryKnowledgeAIIntentSyncOutput(String r100, String r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = null;
        L5:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0010R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/QueryKnowledgeAIIntentOutput$Reference;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "title", "", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getUrl", "toString", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Reference implements Parcelable, Serializable {
        public static final Parcelable.Creator<Reference> CREATOR = null;
        private final String title;
        private final String url;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Reference> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Reference createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                return new Reference(r100.readString(), r100.readString());
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Reference createFromParcel(Parcel r100) {
                return createFromParcel(r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Reference[] newArray(int r100) {
                return new Reference[r100];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Reference[] newArray(int r100) {
                return newArray(r100);
            }
        }

        static {
            CREATOR = new Creator();
        }

        public static /* synthetic */ Reference copy$default(Reference r100, String r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.title;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.url;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.title;
        }

        public final String component2() {
            return this.url;
        }

        public final Reference copy(String r100, String r101) {
            return new Reference(r100, r101);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Reference) == true) goto L8;
            return false;
        L8:
            Reference r101 = (Reference) r100;
            if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.url, r101.url) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r100 = this.title;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.url;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "dest");
            r100.writeString(this.title);
            r100.writeString(this.url);
        }

        public String toString() {
            StringBuilder r100 = new StringBuilder("Reference(title=");
            String r101 = this.title;
            String r102 = null;
            if (r101 == null) goto L5;
            String r103 = a.a(r101);
        L6:
            r100.append(r103);
            r100.append(", url=");
            String r104 = this.url;
            if (r104 == null) goto L9;
            r102 = a.a(r104);
        L9:
            r100.append(r102);
            r100.append(')');
            return r100.toString();
        L5:
            r103 = null;
            goto L6
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getUrl() {
            return this.url;
        }

        public Reference(String r100, String r101) {
            this.title = r100;
            this.url = r101;
        }
    }

    static {
        INSTANCE = new QueryKnowledgeAIIntentOutput();
    }

    private QueryKnowledgeAIIntentOutput() {
    }
}
