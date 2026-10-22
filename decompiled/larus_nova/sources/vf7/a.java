package vf7;

import android.app.Activity;
import android.app.Fragment;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;

/* JADX INFO: loaded from: classes22.dex */
public interface a extends lf7.a {
    void c(Activity r100, String[] r101, int r102, Token r103) throws SensitiveAPIException;

    void requestPermissions(Activity r100, String[] r101, int r102, Token r103) throws SensitiveAPIException;

    void requestPermissions(Fragment r100, String[] r101, int r102, Token r103) throws SensitiveAPIException;

    void requestPermissions(androidx.fragment.app.Fragment r100, String[] r101, int r102, Token r103) throws SensitiveAPIException;
}
