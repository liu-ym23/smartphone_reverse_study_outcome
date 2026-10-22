package org.chromium.support_lib_boundary;

import android.content.Context;
import android.net.Uri;
import android.webkit.ValueCallback;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes42.dex */
public interface StaticsBoundaryInterface {
    Uri getSafeBrowsingPrivacyPolicyUrl();

    String getVariationsHeader();

    void initSafeBrowsing(Context r100, ValueCallback<Boolean> r101);

    boolean isMultiProcessEnabled();

    void setSafeBrowsingAllowlist(Set<String> r100, ValueCallback<Boolean> r101);

    void setSafeBrowsingWhitelist(List<String> r100, ValueCallback<Boolean> r101);
}
