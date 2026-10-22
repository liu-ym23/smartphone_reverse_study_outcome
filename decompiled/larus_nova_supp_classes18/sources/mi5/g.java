package mi5;

import com.larksuite.framework.callback.IGetDataCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface g {
    boolean getLeaderShareSetting(IGetDataCallback<Boolean> r1);

    void shutDown();

    void updateLeaderShareSetting(boolean r1, IGetDataCallback<Boolean> r2);
}
