package xm9;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes29.dex */
public interface a {

    /* JADX INFO: renamed from: xm9.a$a, reason: collision with other inner class name */
    public static final class C8256a {
        public static Context getContext(a r100) {
            return null;
        }
    }

    FragmentActivity getActivity();

    View getContentView();

    Context getContext();

    Integer getFileObjectType();

    String getFileToken();

    WebView getWebView();

    boolean isIntegratedVersion();
}
