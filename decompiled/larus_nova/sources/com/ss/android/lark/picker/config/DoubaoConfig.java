package com.ss.android.lark.picker.config;

import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@PickerMaker
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/picker/config/DoubaoConfig;", "", "<init>", "()V", "bottomBarConfig", "Lcom/ss/android/lark/picker/config/DoubaoConfig$BottomBarConfig;", "getBottomBarConfig", "()Lcom/ss/android/lark/picker/config/DoubaoConfig$BottomBarConfig;", "setBottomBarConfig", "(Lcom/ss/android/lark/picker/config/DoubaoConfig$BottomBarConfig;)V", "onBottomBarActionListener", "Lcom/ss/android/lark/picker/config/DoubaoConfig$OnBottomBarActionListener;", "getOnBottomBarActionListener", "()Lcom/ss/android/lark/picker/config/DoubaoConfig$OnBottomBarActionListener;", "setOnBottomBarActionListener", "(Lcom/ss/android/lark/picker/config/DoubaoConfig$OnBottomBarActionListener;)V", "BottomBarConfig", "OnBottomBarActionListener", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoConfig {
    private BottomBarConfig bottomBarConfig;
    private transient OnBottomBarActionListener onBottomBarActionListener;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J5\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006 "}, d2 = {"Lcom/ss/android/lark/picker/config/DoubaoConfig$BottomBarConfig;", "", "selectedTextTemplate", "", "actionText", "showWhenEmpty", "", "showSelectedAvatarList", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getSelectedTextTemplate", "()Ljava/lang/String;", "setSelectedTextTemplate", "(Ljava/lang/String;)V", "getActionText", "setActionText", "getShowWhenEmpty", "()Z", "setShowWhenEmpty", "(Z)V", "getShowSelectedAvatarList", "setShowSelectedAvatarList", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BottomBarConfig {
        private String actionText;
        private String selectedTextTemplate;
        private boolean showSelectedAvatarList;
        private boolean showWhenEmpty;

        public BottomBarConfig() {
            this(null, null, false, false, 15, null);
        }

        public static /* synthetic */ BottomBarConfig copy$default(BottomBarConfig r100, String r101, String r102, boolean r103, boolean r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.selectedTextTemplate;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.actionText;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.showWhenEmpty;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.showSelectedAvatarList;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final String component1() {
            return this.selectedTextTemplate;
        }

        public final String component2() {
            return this.actionText;
        }

        public final boolean component3() {
            return this.showWhenEmpty;
        }

        public final boolean component4() {
            return this.showSelectedAvatarList;
        }

        public final BottomBarConfig copy(String r100, String r101, boolean r102, boolean r103) {
            return new BottomBarConfig(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof BottomBarConfig) == true) goto L8;
            return false;
        L8:
            BottomBarConfig r101 = (BottomBarConfig) r100;
            if (Intrinsics.areEqual(this.selectedTextTemplate, r101.selectedTextTemplate) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.actionText, r101.actionText) == true) goto L15;
            return false;
        L15:
            if (this.showWhenEmpty == r101.showWhenEmpty) goto L18;
            return false;
        L18:
            if (this.showSelectedAvatarList == r101.showSelectedAvatarList) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            String r100 = this.selectedTextTemplate;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.actionText;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            int r105 = (r103 + r101) * 31;
            int r106 = 1231;
            if (this.showWhenEmpty == false) goto L13;
            int r107 = 1231;
        L14:
            int r108 = (r105 + r107) * 31;
            if (this.showSelectedAvatarList == true) goto L19;
            r106 = 1237;
        L19:
            return r108 + r106;
        L13:
            r107 = 1237;
            goto L14
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "BottomBarConfig(selectedTextTemplate=" + this.selectedTextTemplate + ", actionText=" + this.actionText + ", showWhenEmpty=" + this.showWhenEmpty + ", showSelectedAvatarList=" + this.showSelectedAvatarList + ')';
        }

        public final String getActionText() {
            return this.actionText;
        }

        public final String getSelectedTextTemplate() {
            return this.selectedTextTemplate;
        }

        public final boolean getShowSelectedAvatarList() {
            return this.showSelectedAvatarList;
        }

        public final boolean getShowWhenEmpty() {
            return this.showWhenEmpty;
        }

        public final void setActionText(String r100) {
            this.actionText = r100;
        }

        public final void setSelectedTextTemplate(String r100) {
            this.selectedTextTemplate = r100;
        }

        public final void setShowSelectedAvatarList(boolean r100) {
            this.showSelectedAvatarList = r100;
        }

        public final void setShowWhenEmpty(boolean r100) {
            this.showWhenEmpty = r100;
        }

        public BottomBarConfig(String r100, String r101, boolean r102, boolean r103) {
            this.selectedTextTemplate = r100;
            this.actionText = r101;
            this.showWhenEmpty = r102;
            this.showSelectedAvatarList = r103;
        }

        public /* synthetic */ BottomBarConfig(String r100, String r101, boolean r102, boolean r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = false;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = false;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/picker/config/DoubaoConfig$OnBottomBarActionListener;", "", "onActionClick", "", "selectedItems", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OnBottomBarActionListener {
        void onActionClick(List<? extends SearchBaseInfo> r100);
    }

    public DoubaoConfig() {
    }

    public final BottomBarConfig getBottomBarConfig() {
        return this.bottomBarConfig;
    }

    public final OnBottomBarActionListener getOnBottomBarActionListener() {
        return this.onBottomBarActionListener;
    }

    public final void setBottomBarConfig(BottomBarConfig r100) {
        this.bottomBarConfig = r100;
    }

    public final void setOnBottomBarActionListener(OnBottomBarActionListener r100) {
        this.onBottomBarActionListener = r100;
    }
}
