package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.WireField;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/Position;", "Ljava/io/Serializable;", "()V", GearStrategyConsts.EV_SELECT_BEGIN, "", "end", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Position implements Serializable {
    public static final ProtobufPositionStructV2Adapter ADAPTER = null;
    public static final Companion Companion = null;

    @SerializedName(GearStrategyConsts.EV_SELECT_BEGIN)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public int begin;

    @SerializedName("end")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public int end;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/Position$Companion;", "", "()V", "ADAPTER", "Lcom/ss/android/ugc/aweme/discover/model/ProtobufPositionStructV2Adapter;", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    public Position() {
    }

    static {
        Companion = new Companion(0);
        ADAPTER = new ProtobufPositionStructV2Adapter();
    }
}
