package com.bytedance.android.livesdk.ktvimpl.base.skin;

import com.bytedance.android.livesdk.interactivity.service.wrds.RoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.message.KtvDressSyncData;
import com.bytedance.android.livesdkapi.depend.message.wrds.MultiPreviewSyncDataType;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/skin/KtvDressRoomDataSyncModel;", "Lcom/bytedance/android/livesdk/interactivity/service/wrds/RoomDataSyncModel;", "Ldc2/c;", "Lcom/bytedance/android/livesdkapi/depend/message/KtvDressSyncData;", "ktvDressMidiSkinData$delegate", "Lcom/bytedance/android/livesdk/interactivity/service/wrds/RoomDataSyncModel$a;", "getKtvDressMidiSkinData", "()Ldc2/c;", "ktvDressMidiSkinData", "<init>", "()V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvDressRoomDataSyncModel extends RoomDataSyncModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final RoomDataSyncModel.a ktvDressMidiSkinData$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(KtvDressRoomDataSyncModel.class, "ktvDressMidiSkinData", "getKtvDressMidiSkinData()Lcom/bytedance/android/livesdk/interactivity/service/wrds/WRDSSettingItem;", 0))};
    }

    public final dc2.c<KtvDressSyncData> getKtvDressMidiSkinData() {
        return (dc2.c) this.ktvDressMidiSkinData$delegate.a(this, $$delegatedProperties[0]);
    }

    public KtvDressRoomDataSyncModel() {
        this.ktvDressMidiSkinData$delegate = new RoomDataSyncModel.a(RoomDataSyncModel.access$createSettingItem(this, KtvDressSyncData.class, MultiPreviewSyncDataType.KTV_DRESS_SYNC_DATA.getSyncKey()));
    }
}
