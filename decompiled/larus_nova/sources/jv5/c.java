package jv5;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.alipay.sdk.m.u.i;
import com.baidu.mapapi.http.HttpClient;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f500558a;

    public c() {
        String[] r100 = {"^", Constants.WAVE_SEPARATOR, "&", HiAnalyticsConstant.REPORT_VAL_SEPARATOR, AbsMethodDelegate.TAG_BEFORE, AbsMethodDelegate.TAG_AFTER, Marker.ANY_NON_NULL_MARKER, "-", "*", HTTP.URL_DEFAULT, GXTemplateKey.GAIAX_PE, "++", HttpClient.ENDFLAG, ".", ",", ":", i.f25853b, "(", ")", "{", i.f25855d, "[", "]", "?", "!", "<", ">", "<=", ">=", "==", "!=", "&&", "||", ContainerUtils.KEY_VALUE_DELIMITER, "/**", "**/", "->"};
        this.f500558a = r100;
        Arrays.sort(r100, b.f500557a);
        this.f500558a = r100;
    }
}
