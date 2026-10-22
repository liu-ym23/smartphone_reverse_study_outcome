package com.larus.platform.model.webview;

import android.content.MutableContextWrapper;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/larus/platform/model/webview/AbsWebFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "sendEvent", "", "eventName", "", "params", "Lorg/json/JSONObject;", "getPreloadContextWrapper", "Landroid/content/MutableContextWrapper;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsWebFragment extends Fragment {
    public abstract MutableContextWrapper S90();

    public abstract void T90(String r100, JSONObject r101);

    public AbsWebFragment() {
    }
}
