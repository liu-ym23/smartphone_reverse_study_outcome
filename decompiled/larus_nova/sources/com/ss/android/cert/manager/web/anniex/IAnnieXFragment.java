package com.ss.android.cert.manager.web.anniex;

import androidx.fragment.app.Fragment;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface IAnnieXFragment {
    Fragment getFragment();

    void loadSchema(String r100);

    void sendEvent(String r100, JSONObject r101);
}
