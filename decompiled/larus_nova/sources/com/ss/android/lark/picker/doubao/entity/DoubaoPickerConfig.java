package com.ss.android.lark.picker.doubao.entity;

import com.ss.android.lark.picker.doubao.entity.condition.DoubaoDocCondition;
import com.ss.android.lark.picker.doubao.entity.condition.DoubaoDocTypes;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0004STUVB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00103\"\u0004\b8\u00105R\u001c\u00109\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00103\"\u0004\b;\u00105R\u001a\u0010<\u001a\u00020=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010D\u001a\u00020C2\u0006\u0010B\u001a\u00020C8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001c\u0010I\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00103\"\u0004\bK\u00105R$\u0010L\u001a\f\u0012\u0006\b\u0001\u0012\u00020N\u0018\u00010MX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010R¨\u0006W"}, d2 = {"Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig;", "", "<init>", "()V", "onConfirmListener", "Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig$OnPickerBottomActionListener;", "getOnConfirmListener", "()Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig$OnPickerBottomActionListener;", "setOnConfirmListener", "(Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig$OnPickerBottomActionListener;)V", "onCancelListener", "Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig$IOnCancelListener;", "getOnCancelListener", "()Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig$IOnCancelListener;", "setOnCancelListener", "(Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig$IOnCancelListener;)V", "scene", "Lcom/ss/android/lark/picker/doubao/entity/DobaoPickerScene;", "getScene", "()Lcom/ss/android/lark/picker/doubao/entity/DobaoPickerScene;", "setScene", "(Lcom/ss/android/lark/picker/doubao/entity/DobaoPickerScene;)V", "isMultiSelect", "", "()Z", "setMultiSelect", "(Z)V", "isEnableCancelBtn", "setEnableCancelBtn", "itemConsumer", "Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig$IOnBusinessConsumeItem;", "getItemConsumer", "()Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig$IOnBusinessConsumeItem;", "setItemConsumer", "(Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig$IOnBusinessConsumeItem;)V", "onPickListener", "Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig$IPickSelectNotify;", "getOnPickListener", "()Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig$IPickSelectNotify;", "setOnPickListener", "(Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig$IPickSelectNotify;)V", "defaultEmptyIconResId", "", "getDefaultEmptyIconResId", "()Ljava/lang/Integer;", "setDefaultEmptyIconResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "defaultEmptyHintText", "", "getDefaultEmptyHintText", "()Ljava/lang/String;", "setDefaultEmptyHintText", "(Ljava/lang/String;)V", "searchEmptyHintText", "getSearchEmptyHintText", "setSearchEmptyHintText", "searchBarHintText", "getSearchBarHintText", "setSearchBarHintText", "docTypes", "Lcom/ss/android/lark/picker/doubao/entity/condition/DoubaoDocTypes;", "getDocTypes", "()Lcom/ss/android/lark/picker/doubao/entity/condition/DoubaoDocTypes;", "setDocTypes", "(Lcom/ss/android/lark/picker/doubao/entity/condition/DoubaoDocTypes;)V", "value", "Lcom/ss/android/lark/picker/doubao/entity/condition/DoubaoDocCondition;", "docCondition", "getDocCondition", "()Lcom/ss/android/lark/picker/doubao/entity/condition/DoubaoDocCondition;", "setDocCondition", "(Lcom/ss/android/lark/picker/doubao/entity/condition/DoubaoDocCondition;)V", "selectedCountHintTemplate", "getSelectedCountHintTemplate", "setSelectedCountHintTemplate", "preSelectedItems", "", "Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerEntity;", "getPreSelectedItems", "()Ljava/util/List;", "setPreSelectedItems", "(Ljava/util/List;)V", "IOnBusinessConsumeItem", "IPickSelectNotify", "OnPickerBottomActionListener", "IOnCancelListener", "picker-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoPickerConfig {
    private String defaultEmptyHintText;
    private Integer defaultEmptyIconResId;
    private DoubaoDocTypes docTypes;
    private boolean isEnableCancelBtn;
    private boolean isMultiSelect;
    private IOnBusinessConsumeItem itemConsumer;
    private IOnCancelListener onCancelListener;
    private OnPickerBottomActionListener onConfirmListener;
    private IPickSelectNotify onPickListener;
    private List<DoubaoPickerEntity> preSelectedItems;
    private DobaoPickerScene scene;
    private String searchBarHintText;
    private String searchEmptyHintText;
    private String selectedCountHintTemplate;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig$IOnBusinessConsumeItem;", "", "onBusinessConsumeItemClick", "", "data", "Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerEntity;", "onBusinessBindItemCheckBox", "Lcom/ss/android/lark/picker/doubao/entity/CheckBoxBindStatus;", "picker-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface IOnBusinessConsumeItem {
        CheckBoxBindStatus onBusinessBindItemCheckBox(DoubaoPickerEntity r100);

        boolean onBusinessConsumeItemClick(DoubaoPickerEntity r100);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig$IOnCancelListener;", "", "onCanceled", "", "picker-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface IOnCancelListener {
        void onCanceled();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\bH&J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig$IPickSelectNotify;", "", "<init>", "()V", "onChanged", "", "infoList", "", "Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerEntity;", "onSelected", "info", "onDeSelected", "id", "", "picker-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class IPickSelectNotify {
        public IPickSelectNotify() {
        }

        public abstract void onChanged(List<DoubaoPickerEntity> r100);

        public void onDeSelected(String r100, DoubaoPickerEntity r101) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "info");
        }

        public abstract void onSelected(DoubaoPickerEntity r100);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig$OnPickerBottomActionListener;", "", "onConfirmClick", "", "infoList", "", "Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerEntity;", "onSelectMoreClick", "picker-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OnPickerBottomActionListener {
        void onConfirmClick(List<DoubaoPickerEntity> r100);

        void onSelectMoreClick();
    }

    public DoubaoPickerConfig() {
        this.scene = DobaoPickerScene.UNKNOWN;
        this.isEnableCancelBtn = true;
        this.docTypes = DoubaoPickerConfigKt.access$createDefaultDocTypes();
    }

    public final String getDefaultEmptyHintText() {
        return this.defaultEmptyHintText;
    }

    public final Integer getDefaultEmptyIconResId() {
        return this.defaultEmptyIconResId;
    }

    public final DoubaoDocCondition getDocCondition() {
        return this.docTypes;
    }

    public final DoubaoDocTypes getDocTypes() {
        return this.docTypes;
    }

    public final IOnBusinessConsumeItem getItemConsumer() {
        return this.itemConsumer;
    }

    public final IOnCancelListener getOnCancelListener() {
        return this.onCancelListener;
    }

    public final OnPickerBottomActionListener getOnConfirmListener() {
        return this.onConfirmListener;
    }

    public final IPickSelectNotify getOnPickListener() {
        return this.onPickListener;
    }

    public final List<DoubaoPickerEntity> getPreSelectedItems() {
        return this.preSelectedItems;
    }

    public final DobaoPickerScene getScene() {
        return this.scene;
    }

    public final String getSearchBarHintText() {
        return this.searchBarHintText;
    }

    public final String getSearchEmptyHintText() {
        return this.searchEmptyHintText;
    }

    public final String getSelectedCountHintTemplate() {
        return this.selectedCountHintTemplate;
    }

    public final boolean isEnableCancelBtn() {
        return this.isEnableCancelBtn;
    }

    public final boolean isMultiSelect() {
        return this.isMultiSelect;
    }

    public final void setDefaultEmptyHintText(String r100) {
        this.defaultEmptyHintText = r100;
    }

    public final void setDefaultEmptyIconResId(Integer r100) {
        this.defaultEmptyIconResId = r100;
    }

    public final void setDocCondition(DoubaoDocCondition r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if ((r100 instanceof DoubaoDocTypes) == false) goto L7;
        this.docTypes = (DoubaoDocTypes) r100;
        return;
    L7:
        throw new NoWhenBranchMatchedException();
    }

    public final void setDocTypes(DoubaoDocTypes r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.docTypes = r100;
    }

    public final void setEnableCancelBtn(boolean r100) {
        this.isEnableCancelBtn = r100;
    }

    public final void setItemConsumer(IOnBusinessConsumeItem r100) {
        this.itemConsumer = r100;
    }

    public final void setMultiSelect(boolean r100) {
        this.isMultiSelect = r100;
    }

    public final void setOnCancelListener(IOnCancelListener r100) {
        this.onCancelListener = r100;
    }

    public final void setOnConfirmListener(OnPickerBottomActionListener r100) {
        this.onConfirmListener = r100;
    }

    public final void setOnPickListener(IPickSelectNotify r100) {
        this.onPickListener = r100;
    }

    public final void setPreSelectedItems(List<DoubaoPickerEntity> r100) {
        this.preSelectedItems = r100;
    }

    public final void setScene(DobaoPickerScene r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scene = r100;
    }

    public final void setSearchBarHintText(String r100) {
        this.searchBarHintText = r100;
    }

    public final void setSearchEmptyHintText(String r100) {
        this.searchEmptyHintText = r100;
    }

    public final void setSelectedCountHintTemplate(String r100) {
        this.selectedCountHintTemplate = r100;
    }
}
