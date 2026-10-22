package com.ss.android.lark.picker.base.fg;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.CarUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u001a\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/picker/base/fg/PickerFgUtils;", "", "<init>", "()V", "TAG", "", "FG_KEY_CORE_PICKER_CLOSE_DATA", "FG_KEY_ENABLE_SEARCH_FORSETI", "FG_KEY_DISABLE_ITEM_SELECT_BG", "isClosePickerTracker", "", "isSearchEnableForseti", "isDisableItemSelectBg", "enable", "key", "default", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PickerFgUtils {
    private static final String FG_KEY_CORE_PICKER_CLOSE_DATA = "core.picker.close_data";
    private static final String FG_KEY_DISABLE_ITEM_SELECT_BG = "core.picker.disable_select_item";
    private static final String FG_KEY_ENABLE_SEARCH_FORSETI = "lark.search.enable_forseti";
    public static final PickerFgUtils INSTANCE = null;
    private static final String TAG = "PickerFgUtils";

    static {
        INSTANCE = new PickerFgUtils();
    }

    private PickerFgUtils() {
    }

    public final boolean isClosePickerTracker() {
        boolean r100 = enable$default(this, FG_KEY_CORE_PICKER_CLOSE_DATA, false, 2, null);
        Log.i(TAG, "FG key: core.picker.close_data, enable is: " + r100);
        return r100;
    }

    public final boolean isDisableItemSelectBg() {
        boolean r100 = enable$default(this, FG_KEY_DISABLE_ITEM_SELECT_BG, false, 2, null);
        Log.i(TAG, "FG key: core.picker.disable_select_item, disable is: " + r100);
        return r100;
    }

    public final boolean isSearchEnableForseti() {
        if (CarUtils.a() == false) goto L6;
        return true;
    L6:
        boolean r100 = enable$default(this, FG_KEY_ENABLE_SEARCH_FORSETI, false, 2, null);
        Log.i(TAG, "FG key: lark.search.enable_forseti, enable is: " + r100);
        return r100;
    }

    private final boolean enable(String r100, boolean r101) {
        return FeatureGatingModule.getFeatureGatingService().isEnable(r100, r101);
    }

    public static /* synthetic */ boolean enable$default(PickerFgUtils r100, String r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.enable(r101, r102);
    }
}
