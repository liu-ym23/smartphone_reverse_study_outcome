package com.ss.android.lark.picker.base.view.binder.bridge;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent;", "", "<init>", "()V", "Avatar", "Icon", "Initial", "Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent$Avatar;", "Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent$Icon;", "Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent$Initial;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class LeadingContent {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent$Avatar;", "Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent;", "key", "", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Avatar extends LeadingContent {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final String f438636id;
        private final String key;

        public static /* synthetic */ Avatar copy$default(Avatar r100, String r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.key;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.f438636id;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.key;
        }

        public final String component2() {
            return this.f438636id;
        }

        public final Avatar copy(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "id");
            return new Avatar(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Avatar) == true) goto L8;
            return false;
        L8:
            Avatar r101 = (Avatar) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f438636id, r101.f438636id) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.key.hashCode() * 31) + this.f438636id.hashCode();
        }

        public String toString() {
            return "Avatar(key=" + this.key + ", id=" + this.f438636id + ')';
        }

        public final String getId() {
            return this.f438636id;
        }

        public final String getKey() {
            return this.key;
        }

        public Avatar(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "id");
            super(null);
            this.key = r100;
            this.f438636id = r101;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent$Icon;", "Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent;", "resId", "", "<init>", "(I)V", "getResId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Icon extends LeadingContent {
        private final int resId;

        public static /* synthetic */ Icon copy$default(Icon r100, int r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.resId;
        L6:
            return r100.copy(r101);
        }

        public final int component1() {
            return this.resId;
        }

        public final Icon copy(int r100) {
            return new Icon(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Icon) == true) goto L9;
            return false;
        L9:
            if (this.resId == ((Icon) r100).resId) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.resId;
        }

        public String toString() {
            return "Icon(resId=" + this.resId + ')';
        }

        public final int getResId() {
            return this.resId;
        }

        public Icon(int r100) {
            super(null);
            this.resId = r100;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent$Initial;", "Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Initial extends LeadingContent {
        private final String text;

        public static /* synthetic */ Initial copy$default(Initial r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.text;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.text;
        }

        public final Initial copy(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            return new Initial(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Initial) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.text, ((Initial) r100).text) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "Initial(text=" + this.text + ')';
        }

        public final String getText() {
            return this.text;
        }

        public Initial(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            super(null);
            this.text = r100;
        }
    }

    private LeadingContent() {
    }

    public /* synthetic */ LeadingContent(DefaultConstructorMarker r100) {
        this();
    }
}
