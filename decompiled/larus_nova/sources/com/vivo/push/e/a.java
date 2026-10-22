package com.vivo.push.e;

import com.vivo.push.restructure.request.IPushRequestCallback;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public interface a {
    void addProfileId(String r100, IPushRequestCallback<Integer> r101);

    void deleteAllProfileId(IPushRequestCallback<Integer> r100);

    void deleteProfileId(String r100, IPushRequestCallback<Integer> r101);

    void queryProfileIds(IPushRequestCallback<List<String>> r100);
}
