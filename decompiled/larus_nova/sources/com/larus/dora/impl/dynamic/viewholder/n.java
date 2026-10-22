package com.larus.dora.impl.dynamic.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.dora.impl.databinding.LarusDoraDeviceBatteryLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoBannerLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoDuoGroupLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoFunctionIntroductionSetLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoGeneraGroupLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoLayoutV2Binding;
import com.larus.dora.impl.databinding.LarusDoraDeviceReconnectAndUnbindLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraDeviceSingleProductDisplayV2Binding;
import com.larus.dora.impl.databinding.LarusDoraDynamicListItemBinding;
import com.larus.dora.impl.dynamic.BaseViewHolder;
import com.larus.dora.impl.dynamic.dsl.DslTemplateType;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class n {
    static {
    }

    public static BaseViewHolder a(ViewGroup r210, int r211) {
        Intrinsics.checkNotNullParameter(r210, "parent");
        if (r211 != DslTemplateType.SINGLE_DEVICE_PRODUCT_DISPLAY.ordinal()) goto L25;
        int r100 = DeviceSingleProductDisplayV2Holder.f335304c;
        Intrinsics.checkNotNullParameter(r210, "parent");
        View r101 = LayoutInflater.from(r210.getContext()).inflate(R.layout.larus_dora_device_single_product_display_v2, r210, false);
        int r102 = R.id.dora_device_box_connected_battery;
        View r103 = ViewBindings.findChildViewById(r101, R.id.dora_device_box_connected_battery);
        if (r103 == null) goto L23;
        LarusDoraDeviceBatteryLayoutBinding r104 = LarusDoraDeviceBatteryLayoutBinding.a(r103);
        r102 = R.id.dora_device_box_connected_img;
        SimpleDraweeView r105 = (SimpleDraweeView) ViewBindings.findChildViewById(r101, R.id.dora_device_box_connected_img);
        if (r105 == null) goto L23;
        r102 = R.id.dora_device_connected;
        LinearLayoutCompat r106 = (LinearLayoutCompat) ViewBindings.findChildViewById(r101, R.id.dora_device_connected);
        if (r106 == null) goto L23;
        r102 = R.id.dora_device_connected_battery;
        View r107 = ViewBindings.findChildViewById(r101, R.id.dora_device_connected_battery);
        if (r107 == null) goto L23;
        LarusDoraDeviceBatteryLayoutBinding r110 = LarusDoraDeviceBatteryLayoutBinding.a(r107);
        r102 = R.id.dora_device_connected_img;
        SimpleDraweeView r111 = (SimpleDraweeView) ViewBindings.findChildViewById(r101, R.id.dora_device_connected_img);
        if (r111 == null) goto L23;
        r102 = R.id.dora_device_disconnected;
        DoraTextView r112 = (DoraTextView) ViewBindings.findChildViewById(r101, R.id.dora_device_disconnected);
        if (r112 == null) goto L23;
        r102 = R.id.dora_device_headphone_mode;
        DoraTextView r113 = (DoraTextView) ViewBindings.findChildViewById(r101, R.id.dora_device_headphone_mode);
        if (r113 == null) goto L23;
        r102 = R.id.dora_device_img;
        SimpleDraweeView r114 = (SimpleDraweeView) ViewBindings.findChildViewById(r101, R.id.dora_device_img);
        if (r114 == null) goto L23;
        return new DeviceSingleProductDisplayV2Holder(new LarusDoraDeviceSingleProductDisplayV2Binding((ConstraintLayout) r101, r104, r105, r106, r110, r111, r112, r113, r114));
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    L25:
        if (r211 != DslTemplateType.PRODUCT_DISPLAY.ordinal()) goto L57;
        int r108 = DeviceInfoViewHolder.f335293d;
        Intrinsics.checkNotNullParameter(r210, "parent");
        View r109 = LayoutInflater.from(r210.getContext()).inflate(R.layout.larus_dora_device_info_layout_v2, r210, false);
        int r115 = R.id.barrier;
        Barrier r116 = (Barrier) ViewBindings.findChildViewById(r109, R.id.barrier);
        if (r116 == null) goto L55;
        r115 = R.id.dora_device_battery_box;
        View r117 = ViewBindings.findChildViewById(r109, R.id.dora_device_battery_box);
        if (r117 == null) goto L55;
        LarusDoraDeviceBatteryLayoutBinding r118 = LarusDoraDeviceBatteryLayoutBinding.a(r117);
        r115 = R.id.dora_device_battery_left;
        View r119 = ViewBindings.findChildViewById(r109, R.id.dora_device_battery_left);
        if (r119 == null) goto L55;
        LarusDoraDeviceBatteryLayoutBinding r120 = LarusDoraDeviceBatteryLayoutBinding.a(r119);
        r115 = R.id.dora_device_battery_right;
        View r121 = ViewBindings.findChildViewById(r109, R.id.dora_device_battery_right);
        if (r121 == null) goto L55;
        LarusDoraDeviceBatteryLayoutBinding r122 = LarusDoraDeviceBatteryLayoutBinding.a(r121);
        r115 = R.id.dora_device_disconnect_connect_status_text;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r109, R.id.dora_device_disconnect_connect_status_text)) == null) goto L55;
        r115 = R.id.dora_device_header_connect_group;
        ConstraintLayout r123 = (ConstraintLayout) ViewBindings.findChildViewById(r109, R.id.dora_device_header_connect_group);
        if (r123 == null) goto L55;
        r115 = R.id.dora_device_header_disconnect_group;
        ConstraintLayout r124 = (ConstraintLayout) ViewBindings.findChildViewById(r109, R.id.dora_device_header_disconnect_group);
        if (r124 == null) goto L55;
        r115 = R.id.dora_device_header_group_disconnect;
        FrameLayout r125 = (FrameLayout) ViewBindings.findChildViewById(r109, R.id.dora_device_header_group_disconnect);
        if (r125 == null) goto L55;
        r115 = R.id.dora_device_img_box;
        SimpleDraweeView r126 = (SimpleDraweeView) ViewBindings.findChildViewById(r109, R.id.dora_device_img_box);
        if (r126 == null) goto L55;
        r115 = R.id.dora_device_img_disconnect_left;
        SimpleDraweeView r127 = (SimpleDraweeView) ViewBindings.findChildViewById(r109, R.id.dora_device_img_disconnect_left);
        if (r127 == null) goto L55;
        r115 = R.id.dora_device_img_disconnect_right;
        SimpleDraweeView r128 = (SimpleDraweeView) ViewBindings.findChildViewById(r109, R.id.dora_device_img_disconnect_right);
        if (r128 == null) goto L55;
        r115 = R.id.dora_device_img_left;
        SimpleDraweeView r129 = (SimpleDraweeView) ViewBindings.findChildViewById(r109, R.id.dora_device_img_left);
        if (r129 == null) goto L55;
        r115 = R.id.dora_device_img_right;
        SimpleDraweeView r130 = (SimpleDraweeView) ViewBindings.findChildViewById(r109, R.id.dora_device_img_right);
        if (r130 == null) goto L55;
        NestedScrollView r131 = (NestedScrollView) r109;
        return new DeviceInfoViewHolder(new LarusDoraDeviceInfoLayoutV2Binding(r131, r116, r118, r120, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131));
    L55:
        throw new NullPointerException("Missing required view with ID: ".concat(r109.getResources().getResourceName(r115)));
    L57:
        if (r211 != DslTemplateType.BANNER.ordinal()) goto L71;
        int r132 = DeviceInfoBannerHolder.f335284d;
        Intrinsics.checkNotNullParameter(r210, "parent");
        View r133 = LayoutInflater.from(r210.getContext()).inflate(R.layout.larus_dora_device_info_banner_layout, r210, false);
        int r134 = R.id.dora_item_soda_vip_banner;
        LinearLayoutCompat r135 = (LinearLayoutCompat) ViewBindings.findChildViewById(r133, R.id.dora_item_soda_vip_banner);
        if (r135 == null) goto L69;
        r134 = R.id.dora_soda_vip_banner_close;
        ImageView r136 = (ImageView) ViewBindings.findChildViewById(r133, R.id.dora_soda_vip_banner_close);
        if (r136 == null) goto L69;
        r134 = R.id.dora_soda_vip_sub_title;
        AppCompatTextView r137 = (AppCompatTextView) ViewBindings.findChildViewById(r133, R.id.dora_soda_vip_sub_title);
        if (r137 == null) goto L69;
        r134 = R.id.dora_soda_vip_title;
        DoraTextView r138 = (DoraTextView) ViewBindings.findChildViewById(r133, R.id.dora_soda_vip_title);
        if (r138 == null) goto L69;
        return new DeviceInfoBannerHolder(new LarusDoraDeviceInfoBannerLayoutBinding((ItemGroup) r133, r135, r136, r137, r138));
    L69:
        throw new NullPointerException("Missing required view with ID: ".concat(r133.getResources().getResourceName(r134)));
    L71:
        if (r211 != DslTemplateType.GENERAL_GROUP.ordinal()) goto L75;
        int r139 = GeneralGroupHolder.f335324e;
        Intrinsics.checkNotNullParameter(r210, "parent");
        return new GeneralGroupHolder(LarusDoraDeviceInfoGeneraGroupLayoutBinding.a(LayoutInflater.from(r210.getContext()), r210));
    L75:
        if (r211 != DslTemplateType.DUO_GROUP.ordinal()) goto L83;
        int r140 = DuoGroupHolder.f335313e;
        Intrinsics.checkNotNullParameter(r210, "parent");
        View r141 = LayoutInflater.from(r210.getContext()).inflate(R.layout.larus_dora_device_info_duo_group_layout, r210, false);
        if (r141 == null) goto L81;
        GridLayout r142 = (GridLayout) r141;
        return new DuoGroupHolder(new LarusDoraDeviceInfoDuoGroupLayoutBinding(r142, r142));
    L81:
        throw new NullPointerException("rootView");
    L83:
        if (r211 != DslTemplateType.FUNCTION_INTRODUCTION_SET.ordinal()) goto L91;
        int r143 = FunctionIntroductionSetHolder.f335318c;
        Intrinsics.checkNotNullParameter(r210, "parent");
        View r144 = LayoutInflater.from(r210.getContext()).inflate(R.layout.larus_dora_device_info_function_introduction_set_layout, r210, false);
        LinearLayout r145 = (LinearLayout) r144;
        if (((DoraTextView) ViewBindings.findChildViewById(r144, R.id.function_introduction_set_title)) == null) goto L89;
        return new FunctionIntroductionSetHolder(new LarusDoraDeviceInfoFunctionIntroductionSetLayoutBinding(r145, r145));
    L89:
        throw new NullPointerException("Missing required view with ID: ".concat(r144.getResources().getResourceName(R.id.function_introduction_set_title)));
    L91:
        if (r211 != DslTemplateType.PRODUCT_ITEM.ordinal()) goto L95;
        int r146 = ProductItemHolder.f335334b;
        Intrinsics.checkNotNullParameter(r210, "parent");
        return new ProductItemHolder(LarusDoraDynamicListItemBinding.a(LayoutInflater.from(r210.getContext()), r210));
    L95:
        if (r211 != DslTemplateType.RECONNECT_UNBIND_PANEL.ordinal()) goto L108;
        int r147 = DeviceReConnectAndUnbindHolder.f335298e;
        Intrinsics.checkNotNullParameter(r210, "parent");
        View r148 = LayoutInflater.from(r210.getContext()).inflate(R.layout.larus_dora_device_reconnect_and_unbind_layout, r210, false);
        int r149 = R.id.dora_device_disconnect_connect_container;
        LinearLayout r150 = (LinearLayout) ViewBindings.findChildViewById(r148, R.id.dora_device_disconnect_connect_container);
        if (r150 == null) goto L107;
        r149 = R.id.dora_device_disconnect_connect_text;
        AppCompatTextView r151 = (AppCompatTextView) ViewBindings.findChildViewById(r148, R.id.dora_device_disconnect_connect_text);
        if (r151 == null) goto L107;
        r149 = R.id.dora_device_unbind_text;
        AppCompatTextView r152 = (AppCompatTextView) ViewBindings.findChildViewById(r148, R.id.dora_device_unbind_text);
        if (r152 == null) goto L107;
        LinearLayout r153 = (LinearLayout) r148;
        r149 = R.id.loading_spinner;
        ProgressBar r154 = (ProgressBar) ViewBindings.findChildViewById(r148, R.id.loading_spinner);
        if (r154 == null) goto L107;
        return new DeviceReConnectAndUnbindHolder(new LarusDoraDeviceReconnectAndUnbindLayoutBinding(r153, r150, r151, r152, r154));
    L107:
        throw new NullPointerException("Missing required view with ID: ".concat(r148.getResources().getResourceName(r149)));
    L108:
        int r155 = GeneralGroupHolder.f335324e;
        Intrinsics.checkNotNullParameter(r210, "parent");
        return new GeneralGroupHolder(LarusDoraDeviceInfoGeneraGroupLayoutBinding.a(LayoutInflater.from(r210.getContext()), r210));
    }
}
