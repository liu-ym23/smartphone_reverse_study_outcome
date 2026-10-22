package com.obric.aiagent.product.platform.api.rom;

import android.util.EventsUtils;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\f\u001a\u00020\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u000eH&J\b\u0010\u000f\u001a\u00020\nH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0005H&J\b\u0010\u0013\u001a\u00020\u0005H&J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0011H&¨\u0006\u0018"}, d2 = {"Lcom/obric/aiagent/product/platform/api/rom/IRomInfo;", XmlPullParser.NO_NAMESPACE, "tryInit", XmlPullParser.NO_NAMESPACE, "getDeviceBrand", XmlPullParser.NO_NAMESPACE, "getDeviceModel", "getOSVersion", "getShortOSVersion", "getOSReleaseDate", XmlPullParser.NO_NAMESPACE, "getOSDeviceIdFromCache", "getOSDeviceIdAsync", "callback", "Lkotlin/Function1;", "getFwkApiVersion", "useAssistantApi", XmlPullParser.NO_NAMESPACE, "getRomReleaseRegion", "getRomBuildType", "isOautoModelPreinstalled", "context", "Landroid/content/Context;", "isUTRom", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IRomInfo {
    String a();

    String b();

    int c();

    boolean d();

    boolean e();

    String f();

    String g();

    String getDeviceBrand();

    String getDeviceModel();

    String getOSVersion();

    int h();

    void i();
}
