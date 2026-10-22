package com.obric.assistant.spi.launch;

import android.util.EventsUtils;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/obric/assistant/spi/launch/IObricLazyInitSettingsService;", XmlPullParser.NO_NAMESPACE, "isIvyKitLazyInitEnabled", XmlPullParser.NO_NAMESPACE, "isAppletLazyInitEnabled", "isTTVideoEngineLazyInitEnabled", "isLocalLifeLazyInitEnabled", "isECommerceLazyInitEnabled", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IObricLazyInitSettingsService {
    boolean a();

    boolean b();

    boolean c();

    boolean d();

    boolean e();
}
