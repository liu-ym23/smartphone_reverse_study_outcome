package com.bytedance.expressecom;

import android.util.LruCache;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.alipay.sdk.m.u.i;
import com.baidu.mapapi.http.HttpClient;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import kv5.d;
import lv5.w;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.expressecom.a$a, reason: collision with other inner class name */
    public static final class C3488a {
    }

    static {
    }

    public a() {
        new d();
        new LruCache(1000);
        new w();
        Arrays.sort(new String[]{"^", Constants.WAVE_SEPARATOR, "&", HiAnalyticsConstant.REPORT_VAL_SEPARATOR, AbsMethodDelegate.TAG_BEFORE, AbsMethodDelegate.TAG_AFTER, Marker.ANY_NON_NULL_MARKER, "-", "*", HTTP.URL_DEFAULT, GXTemplateKey.GAIAX_PE, "++", HttpClient.ENDFLAG, ".", ",", ":", i.f25853b, "(", ")", "{", i.f25855d, "[", "]", "?", "!", "<", ">", "<=", ">=", "==", "!=", "&&", "||", ContainerUtils.KEY_VALUE_DELIMITER, "/**", "**/", "->"}, mv5.b.f515892a);
    }
}
