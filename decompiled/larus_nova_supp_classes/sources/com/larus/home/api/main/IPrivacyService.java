package com.larus.home.api.main;

import android.util.EventsUtils;
import com.larus.nova.view.FlowBDAuthorizeActivity;
import com.larus.nova.view.c;
import com.larus.nova.view.d;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH&¨\u0006\u000b"}, d2 = {"Lcom/larus/home/api/main/IPrivacyService;", XmlPullParser.NO_NAMESPACE, "isPrivacyAgreed", XmlPullParser.NO_NAMESPACE, "showPrivacyDialog", XmlPullParser.NO_NAMESPACE, "activity", "Landroid/app/Activity;", "successCallback", "Lkotlin/Function0;", "failCallback", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IPrivacyService {
    boolean a();

    void b(FlowBDAuthorizeActivity r1, c r2, d r3);
}
