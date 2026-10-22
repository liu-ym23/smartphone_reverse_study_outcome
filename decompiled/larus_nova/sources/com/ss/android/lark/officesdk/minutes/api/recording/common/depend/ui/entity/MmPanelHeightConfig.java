package com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelHeightConfig;", "Ljava/io/Serializable;", "<init>", "()V", "ScreenTopMargin", "Fixed", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelHeightConfig$Fixed;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelHeightConfig$ScreenTopMargin;", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class MmPanelHeightConfig implements Serializable {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelHeightConfig$Fixed;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelHeightConfig;", "heightPx", "", "isExpanded", "", "<init>", "(IZ)V", "getHeightPx", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Fixed extends MmPanelHeightConfig {
        private final int heightPx;
        private final boolean isExpanded;

        public static /* synthetic */ Fixed copy$default(Fixed r100, int r101, boolean r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.heightPx;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.isExpanded;
        L9:
            return r100.copy(r101, r102);
        }

        public final int component1() {
            return this.heightPx;
        }

        public final boolean component2() {
            return this.isExpanded;
        }

        public final Fixed copy(int r100, boolean r101) {
            return new Fixed(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Fixed) == true) goto L8;
            return false;
        L8:
            Fixed r101 = (Fixed) r100;
            if (this.heightPx == r101.heightPx) goto L12;
            return false;
        L12:
            if (this.isExpanded == r101.isExpanded) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r100 = this.heightPx * 31;
            if (this.isExpanded == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public String toString() {
            return "Fixed(heightPx=" + this.heightPx + ", isExpanded=" + this.isExpanded + ')';
        }

        public final int getHeightPx() {
            return this.heightPx;
        }

        public final boolean isExpanded() {
            return this.isExpanded;
        }

        public Fixed(int r100, boolean r101) {
            super(null);
            this.heightPx = r100;
            this.isExpanded = r101;
        }

        public /* synthetic */ Fixed(int r100, boolean r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = true;
        L5:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelHeightConfig$ScreenTopMargin;", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelHeightConfig;", "marginPx", "", "isExpanded", "", "<init>", "(IZ)V", "getMarginPx", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ScreenTopMargin extends MmPanelHeightConfig {
        private final boolean isExpanded;
        private final int marginPx;

        public static /* synthetic */ ScreenTopMargin copy$default(ScreenTopMargin r100, int r101, boolean r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.marginPx;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.isExpanded;
        L9:
            return r100.copy(r101, r102);
        }

        public final int component1() {
            return this.marginPx;
        }

        public final boolean component2() {
            return this.isExpanded;
        }

        public final ScreenTopMargin copy(int r100, boolean r101) {
            return new ScreenTopMargin(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ScreenTopMargin) == true) goto L8;
            return false;
        L8:
            ScreenTopMargin r101 = (ScreenTopMargin) r100;
            if (this.marginPx == r101.marginPx) goto L12;
            return false;
        L12:
            if (this.isExpanded == r101.isExpanded) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r100 = this.marginPx * 31;
            if (this.isExpanded == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public String toString() {
            return "ScreenTopMargin(marginPx=" + this.marginPx + ", isExpanded=" + this.isExpanded + ')';
        }

        public final int getMarginPx() {
            return this.marginPx;
        }

        public final boolean isExpanded() {
            return this.isExpanded;
        }

        public ScreenTopMargin(int r100, boolean r101) {
            super(null);
            this.marginPx = r100;
            this.isExpanded = r101;
        }

        public /* synthetic */ ScreenTopMargin(int r100, boolean r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = true;
        L5:
            this(r100, r101);
        }
    }

    private MmPanelHeightConfig() {
    }

    public /* synthetic */ MmPanelHeightConfig(DefaultConstructorMarker r100) {
        this();
    }
}
