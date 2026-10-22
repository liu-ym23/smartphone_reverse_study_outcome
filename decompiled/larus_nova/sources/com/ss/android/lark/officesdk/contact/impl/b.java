package com.ss.android.lark.officesdk.contact.impl;

import android.content.Context;
import android.content.Intent;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.settings.v1.DoubaoAddFriendSetting;
import com.bytedance.lark.pb.settings.v1.GetDoubaoAddFriendSettingRequest;
import com.bytedance.lark.pb.settings.v1.UpdateDoubaoAddFriendSettingRequest;
import com.bytedance.lark.pb.settings.v1.WayToAddFriendItem;
import com.larus.bmhome.n0;
import com.larus.bmhome.p0;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.setting.api.o;
import com.larus.setting.api.s;
import com.ss.android.lark.contact.customized.OfficeContactPageUtils;
import com.ss.android.lark.contact.customized.externalcontact.repository.NewFriendBadgeRepository;
import com.ss.android.lark.contact.customized.externalcontact.repository.c;
import com.ss.android.lark.contact.customized.externalcontact.repository.d;
import com.ss.android.lark.contact.customized.externalcontact.view.OfficeExternalContactFragment;
import com.ss.android.lark.contact.customized.externalinvite.OfficeInviteExternalActivity;
import com.ss.android.lark.contact.customized.myqrcode.OfficeMyQrCodeActivity;
import com.ss.android.lark.contact.customized.search.OfficeInviteExternalSearchActivity;
import com.ss.android.lark.contact.customized.setting.DoubaoAddFriendSettingRepository;
import com.ss.android.lark.contact.customized.setting.DoubaoAddFriendSettingRepository$toSdkCallback$1;
import com.ss.android.lark.contact.customized.setting.DoubaoAddFriendSettingRepository$updateSetting$1;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.contact.api.model.DoubaoAddFriendSettingType;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.sdk.f;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mtb.e;
import mtb.l;

/* JADX INFO: loaded from: classes37.dex */
@OfficeSDKUserScope
public final class b implements ktb.a {
    @Inject
    public b() {
    }

    @Override // ktb.a
    public final void V7(final o r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Lazy r101 = DoubaoAddFriendSettingRepository.f419431a;
        Intrinsics.checkNotNullParameter(r100, "callback");
        Log.i("Contact_AddFriendSetting", "getSetting start");
        GetDoubaoAddFriendSettingRequest.Builder r102 = new GetDoubaoAddFriendSettingRequest.Builder();
        SdkSender.asynSendRequestNonWrap(Command.GET_DOUBAO_ADD_FRIEND_SETTING, r102, new DoubaoAddFriendSettingRepository$toSdkCallback$1(r100), com.ss.android.lark.contact.customized.setting.a.f419434a);
    }

    @Override // ktb.a
    public final void W9(n0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Lazy r101 = NewFriendBadgeRepository.f419129a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        Log.i("Contact_NewFriendBadge", "addListener");
        f.a((CopyOnWriteArrayList) NewFriendBadgeRepository.f419129a.getValue(), r100, c.f419137a);
    }

    @Override // ktb.a
    public final OfficeExternalContactFragment Z7(mtb.a r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Lazy r101 = OfficeContactPageUtils.f418959a;
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        int r102 = OfficeExternalContactFragment.f419163r;
        return OfficeExternalContactFragment.a.a(false, r100.f515659a, r100.f515660b);
    }

    @Override // ktb.a
    public final void t1(ltb.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Lazy r101 = NewFriendBadgeRepository.f419129a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        Log.i("Contact_NewFriendBadge", "removeListener");
        f.b((CopyOnWriteArrayList) NewFriendBadgeRepository.f419129a.getValue(), r100, d.f419138a);
    }

    @Override // ktb.a
    public final void t7(p0 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Lazy r101 = NewFriendBadgeRepository.f419129a;
        NewFriendBadgeRepository.a(NewFriendBadgeRepository.Source.EXTERNAL_API, r100);
    }

    @Override // ktb.a
    public final void F1(Context r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "intent");
        Lazy r102 = OfficeContactPageUtils.f418959a;
        String r103 = r101.f515694a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "from");
        int r104 = OfficeMyQrCodeActivity.f419318a;
        OfficeMyQrCodeActivity.a.a(r100, r103);
    }

    @Override // ktb.a
    public final void Gc(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "from");
        Lazy r102 = OfficeContactPageUtils.f418959a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r103 = OfficeInviteExternalActivity.f419261a;
        OfficeInviteExternalActivity.a.a(r100, r101);
    }

    @Override // ktb.a
    public final void U8(Context r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Lazy r102 = OfficeContactPageUtils.f418959a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        int r103 = OfficeInviteExternalSearchActivity.f419401a;
        Intent r104 = new Intent(r100, OfficeInviteExternalSearchActivity.class);
        r104.putExtra("contact_db_initial_keyword", r101.f515673a);
        r104.putExtra("from", r101.f515674b);
        r100.startActivity(r104);
    }

    @Override // ktb.a
    public final void Ub(mtb.f r100, s r101) {
        Intrinsics.checkNotNullParameter(r100, "settingsItem");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Lazy r102 = DoubaoAddFriendSettingRepository.f419431a;
        final DoubaoAddFriendSettingType r103 = r100.f515675a;
        final boolean r104 = r100.f515678d;
        final a r105 = new a(r101, r100);
        Intrinsics.checkNotNullParameter(r103, "settingType");
        Intrinsics.checkNotNullParameter(r105, "callback");
        Log.i("Contact_AddFriendSetting", "updateSetting start type=" + r103 + " enabled=" + r104);
        DoubaoAddFriendSetting.Builder r106 = new DoubaoAddFriendSetting.Builder();
        int r107 = DoubaoAddFriendSettingRepository.a.f419433b[r103.ordinal()];
        if (r107 != 1) goto L5;
        int r108 = WayToAddFriendItem.WAY_TO_ADD_FRIEND_ITEM_CHAT.getValue();
    L16:
        SdkSender.asynSendRequestNonWrap(Command.UPDATE_DOUBAO_ADD_FRIEND_SETTING, new UpdateDoubaoAddFriendSettingRequest.Builder().setting(r106.way_to_add_friend_items(MapsKt.mapOf(TuplesKt.to(Integer.valueOf(r108), Boolean.valueOf(r104)))).build()), new DoubaoAddFriendSettingRepository$updateSetting$1(r103, r104, r105), com.ss.android.lark.contact.customized.setting.b.f419435a);
        return;
    L5:
        if (r107 != 2) goto L7;
        r108 = WayToAddFriendItem.WAY_TO_ADD_FRIEND_ITEM_CONTACT_TOKEN.getValue();
        goto L16
    L7:
        if (r107 != 3) goto L9;
        r108 = WayToAddFriendItem.WAY_TO_ADD_FRIEND_ITEM_NAME_CARD.getValue();
        goto L16
    L9:
        if (r107 != 4) goto L12;
        r108 = WayToAddFriendItem.WAY_TO_ADD_FRIEND_ITEM_DOCS.getValue();
        goto L16
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
