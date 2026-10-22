package com.bytedance.bdp.appbase.service.protocol.device;

import com.bytedance.bdp.appbase.context.BdpAppContext;
import com.bytedance.bdp.appbase.context.service.ContextService;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/bdp/appbase/service/protocol/device/DeviceService;", "Lcom/bytedance/bdp/appbase/context/service/ContextService;", "Lcom/bytedance/bdp/appbase/context/BdpAppContext;", "ScreenBrightness", "VolumeValue", "bdp-appbase_release"}, k = 1, mv = {1, 4, 0})
public abstract class DeviceService extends ContextService<BdpAppContext> {

    @Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE_USE})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/bdp/appbase/service/protocol/device/DeviceService$ScreenBrightness;", "", "bdp-appbase_release"}, k = 1, mv = {1, 1, 18})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ScreenBrightness {
    }

    @Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE_USE})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/bdp/appbase/service/protocol/device/DeviceService$VolumeValue;", "", "bdp-appbase_release"}, k = 1, mv = {1, 1, 18})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface VolumeValue {
    }
}
