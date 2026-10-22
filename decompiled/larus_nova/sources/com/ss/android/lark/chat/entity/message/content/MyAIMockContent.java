package com.ss.android.lark.chat.entity.message.content;

import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/MyAIMockContent;", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "<init>", "()V", "PlainText", "Preview", "LoadMore", "Lcom/ss/android/lark/chat/entity/message/content/MyAIMockContent$LoadMore;", "Lcom/ss/android/lark/chat/entity/message/content/MyAIMockContent$PlainText;", "Lcom/ss/android/lark/chat/entity/message/content/MyAIMockContent$Preview;", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class MyAIMockContent extends Content {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/MyAIMockContent$LoadMore;", "Lcom/ss/android/lark/chat/entity/message/content/MyAIMockContent;", "isLoading", "", "<init>", "(Z)V", "()Z", "isContentSame", "diffable", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LoadMore extends MyAIMockContent {
        private final boolean isLoading;

        public static /* synthetic */ LoadMore copy$default(LoadMore r100, boolean r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.isLoading;
        L6:
            return r100.copy(r101);
        }

        public final boolean component1() {
            return this.isLoading;
        }

        public final LoadMore copy(boolean r100) {
            return new LoadMore(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof LoadMore) == true) goto L9;
            return false;
        L9:
            if (this.isLoading == ((LoadMore) r100).isLoading) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            if (this.isLoading == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public String toString() {
            return "LoadMore(isLoading=" + this.isLoading + ')';
        }

        public final boolean isLoading() {
            return this.isLoading;
        }

        public LoadMore(boolean r100) {
            super(null);
            this.isLoading = r100;
        }

        @Override // com.ss.android.lark.chat.export.entity.message.Content
        public boolean isContentSame(Content r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof LoadMore) == true) goto L8;
        L10:
            return false;
        L8:
            if (Intrinsics.areEqual(this, r100) == false) goto L10;
            return true;
        }

        @Override // com.ss.android.lark.chat.export.entity.message.Content, y28.b
        public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
            return isContentSame((Content) r100);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/MyAIMockContent$PlainText;", "Lcom/ss/android/lark/chat/entity/message/content/MyAIMockContent;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "isContentSame", "", "diffable", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PlainText extends MyAIMockContent {
        private final String text;

        public static /* synthetic */ PlainText copy$default(PlainText r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.text;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.text;
        }

        public final PlainText copy(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            return new PlainText(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof PlainText) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.text, ((PlainText) r100).text) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "PlainText(text=" + this.text + ')';
        }

        public final String getText() {
            return this.text;
        }

        public PlainText(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            super(null);
            this.text = r100;
        }

        @Override // com.ss.android.lark.chat.export.entity.message.Content
        public boolean isContentSame(Content r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof PlainText) == true) goto L8;
        L10:
            return false;
        L8:
            if (Intrinsics.areEqual(this, r100) == false) goto L10;
            return true;
        }

        @Override // com.ss.android.lark.chat.export.entity.message.Content, y28.b
        public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
            return isContentSame((Content) r100);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/MyAIMockContent$Preview;", "Lcom/ss/android/lark/chat/entity/message/content/MyAIMockContent;", "isExpand", "", "previewData", "Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;", DyPayConstant.KEY_SHOW_LOADING, "rootMessageId", "", "<init>", "(ZLcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;ZLjava/lang/String;)V", "()Z", "getPreviewData", "()Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;", "getShowLoading", "getRootMessageId", "()Ljava/lang/String;", "isContentSame", "diffable", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Preview extends MyAIMockContent {
        private final boolean isExpand;
        private final UrlInlinePreviewEntity previewData;
        private final String rootMessageId;
        private final boolean showLoading;

        public static /* synthetic */ Preview copy$default(Preview r100, boolean r101, UrlInlinePreviewEntity r102, boolean r103, String r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.isExpand;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.previewData;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.showLoading;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.rootMessageId;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final boolean component1() {
            return this.isExpand;
        }

        public final UrlInlinePreviewEntity component2() {
            return this.previewData;
        }

        public final boolean component3() {
            return this.showLoading;
        }

        public final String component4() {
            return this.rootMessageId;
        }

        public final Preview copy(boolean r100, UrlInlinePreviewEntity r101, boolean r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "previewData");
            Intrinsics.checkNotNullParameter(r103, "rootMessageId");
            return new Preview(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Preview) == true) goto L8;
            return false;
        L8:
            Preview r101 = (Preview) r100;
            if (this.isExpand == r101.isExpand) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.previewData, r101.previewData) == true) goto L15;
            return false;
        L15:
            if (this.showLoading == r101.showLoading) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.rootMessageId, r101.rootMessageId) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r100 = 1231;
            if (this.isExpand == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = ((r101 * 31) + this.previewData.hashCode()) * 31;
            if (this.showLoading == true) goto L11;
            r100 = 1237;
        L11:
            return ((r102 + r100) * 31) + this.rootMessageId.hashCode();
        L5:
            r101 = 1237;
            goto L6
        }

        public String toString() {
            return "Preview(isExpand=" + this.isExpand + ", previewData=" + this.previewData + ", showLoading=" + this.showLoading + ", rootMessageId=" + this.rootMessageId + ')';
        }

        public final UrlInlinePreviewEntity getPreviewData() {
            return this.previewData;
        }

        public final String getRootMessageId() {
            return this.rootMessageId;
        }

        public final boolean getShowLoading() {
            return this.showLoading;
        }

        public final boolean isExpand() {
            return this.isExpand;
        }

        @Override // com.ss.android.lark.chat.export.entity.message.Content
        public boolean isContentSame(Content r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Preview) == true) goto L8;
        L10:
            return false;
        L8:
            if (Intrinsics.areEqual(this, r100) == false) goto L10;
            return true;
        }

        @Override // com.ss.android.lark.chat.export.entity.message.Content, y28.b
        public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
            return isContentSame((Content) r100);
        }

        public Preview(boolean r100, UrlInlinePreviewEntity r101, boolean r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "previewData");
            Intrinsics.checkNotNullParameter(r103, "rootMessageId");
            super(null);
            this.isExpand = r100;
            this.previewData = r101;
            this.showLoading = r102;
            this.rootMessageId = r103;
        }
    }

    public /* synthetic */ MyAIMockContent(DefaultConstructorMarker r100) {
        this();
    }

    private MyAIMockContent() {
    }
}
