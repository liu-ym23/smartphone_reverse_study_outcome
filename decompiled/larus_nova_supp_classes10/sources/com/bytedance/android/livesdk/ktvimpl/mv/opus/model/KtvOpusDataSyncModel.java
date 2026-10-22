package com.bytedance.android.livesdk.ktvimpl.mv.opus.model;

import com.bytedance.android.livesdk.interactivity.service.wrds.RoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.message.KtvStreamSingSyncData;
import com.bytedance.android.livesdkapi.depend.message.wrds.MultiPreviewSyncDataType;
import dc2.c;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/mv/opus/model/KtvOpusDataSyncModel;", "Lcom/bytedance/android/livesdk/interactivity/service/wrds/RoomDataSyncModel;", "Ldc2/c;", "Lcom/bytedance/android/livesdkapi/depend/message/KtvStreamSingSyncData;", "KtvOpusSyncData$delegate", "Lcom/bytedance/android/livesdk/interactivity/service/wrds/RoomDataSyncModel$a;", "getKtvOpusSyncData", "()Ldc2/c;", "KtvOpusSyncData", "<init>", "()V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvOpusDataSyncModel extends RoomDataSyncModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final RoomDataSyncModel.a KtvOpusSyncData$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(KtvOpusDataSyncModel.class, "KtvOpusSyncData", "getKtvOpusSyncData()Lcom/bytedance/android/livesdk/interactivity/service/wrds/WRDSSettingItem;", 0))};
    }

    public final c<KtvStreamSingSyncData> getKtvOpusSyncData() {
        return (c) this.KtvOpusSyncData$delegate.a(this, $$delegatedProperties[0]);
    }

    public KtvOpusDataSyncModel() {
        this.KtvOpusSyncData$delegate = new RoomDataSyncModel.a(RoomDataSyncModel.access$createSettingItem(this, KtvStreamSingSyncData.class, MultiPreviewSyncDataType.KTV_STREAM_SING_SYNC_DATA.getSyncKey()));
    }
}
