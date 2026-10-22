package com.obric.livecard.api;

import android.os.Bundle;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001f\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\tH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/obric/livecard/api/DefaultIslandCardCallback;", "Lcom/obric/livecard/api/IslandCardCallback;", "onSessionActive", "", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/obric/livecard/api/entity/IslandSession;", "onSessionCreate", "onSessionDestroy", "reason", "", "(Lcom/obric/livecard/api/entity/IslandSession;Ljava/lang/Integer;)V", "onSessionDisplayStatusChanged", "status", "onSessionInactive", "onSessionStatusChanged", "onWidgetShow", "Landroid/os/Bundle;", "widget", "Lcom/obric/livecard/api/entity/IslandWidget;", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface DefaultIslandCardCallback extends IslandCardCallback {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static void onSessionActive(DefaultIslandCardCallback r100, IslandSession r101) {
            Intrinsics.checkNotNullParameter(r101, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        }

        public static void onSessionCreate(DefaultIslandCardCallback r100, IslandSession r101) {
            Intrinsics.checkNotNullParameter(r101, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        }

        public static void onSessionDestroy(DefaultIslandCardCallback r100, IslandSession r101, Integer r102) {
            Intrinsics.checkNotNullParameter(r101, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        }

        public static void onSessionDisplayStatusChanged(DefaultIslandCardCallback r100, IslandSession r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        }

        public static void onSessionInactive(DefaultIslandCardCallback r100, IslandSession r101) {
            Intrinsics.checkNotNullParameter(r101, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        }

        public static void onSessionStatusChanged(DefaultIslandCardCallback r100, IslandSession r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        }

        public static Bundle onWidgetShow(DefaultIslandCardCallback r100, IslandWidget r101) {
            Intrinsics.checkNotNullParameter(r101, "widget");
            return null;
        }
    }

    @Override // com.obric.livecard.api.IslandCardCallback
    void onSessionActive(IslandSession r100);

    @Override // com.obric.livecard.api.IslandCardCallback
    void onSessionCreate(IslandSession r100);

    @Override // com.obric.livecard.api.IslandCardCallback
    void onSessionDestroy(IslandSession r100, Integer r101);

    @Override // com.obric.livecard.api.IslandCardCallback
    void onSessionDisplayStatusChanged(IslandSession r100, int r101);

    @Override // com.obric.livecard.api.IslandCardCallback
    void onSessionInactive(IslandSession r100);

    @Override // com.obric.livecard.api.IslandCardCallback
    void onSessionStatusChanged(IslandSession r100, int r101);

    @Override // com.obric.livecard.api.IslandCardCallback
    Bundle onWidgetShow(IslandWidget r100);
}
