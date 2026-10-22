package com.ss.android.lark.picker.extra;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/extra/SelectedPreviewStyle;", "", "<init>", "()V", "PreviewList", "SelectedNumber", "Lcom/ss/android/lark/picker/extra/SelectedPreviewStyle$PreviewList;", "Lcom/ss/android/lark/picker/extra/SelectedPreviewStyle$SelectedNumber;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class SelectedPreviewStyle {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/picker/extra/SelectedPreviewStyle$PreviewList;", "Lcom/ss/android/lark/picker/extra/SelectedPreviewStyle;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PreviewList extends SelectedPreviewStyle {
        public static final PreviewList INSTANCE = null;

        static {
            INSTANCE = new PreviewList();
        }

        private PreviewList() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/picker/extra/SelectedPreviewStyle$SelectedNumber;", "Lcom/ss/android/lark/picker/extra/SelectedPreviewStyle;", "updateListener", "Lcom/ss/android/lark/picker/extra/OnNumberUpdateListener;", "<init>", "(Lcom/ss/android/lark/picker/extra/OnNumberUpdateListener;)V", "getUpdateListener", "()Lcom/ss/android/lark/picker/extra/OnNumberUpdateListener;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SelectedNumber extends SelectedPreviewStyle {
        private final OnNumberUpdateListener updateListener;

        public static /* synthetic */ SelectedNumber copy$default(SelectedNumber r100, OnNumberUpdateListener r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.updateListener;
        L6:
            return r100.copy(r101);
        }

        public final OnNumberUpdateListener component1() {
            return this.updateListener;
        }

        public final SelectedNumber copy(OnNumberUpdateListener r100) {
            Intrinsics.checkNotNullParameter(r100, "updateListener");
            return new SelectedNumber(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof SelectedNumber) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.updateListener, ((SelectedNumber) r100).updateListener) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.updateListener.hashCode();
        }

        public String toString() {
            return "SelectedNumber(updateListener=" + this.updateListener + ')';
        }

        public final OnNumberUpdateListener getUpdateListener() {
            return this.updateListener;
        }

        public SelectedNumber(OnNumberUpdateListener r100) {
            Intrinsics.checkNotNullParameter(r100, "updateListener");
            super(null);
            this.updateListener = r100;
        }
    }

    private SelectedPreviewStyle() {
    }

    public /* synthetic */ SelectedPreviewStyle(DefaultConstructorMarker r100) {
        this();
    }
}
