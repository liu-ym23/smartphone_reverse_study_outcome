package pmb;

import android.app.Activity;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public interface c {
    void pickGroupMember(Activity r100, String r101, List<String> r102, boolean r103, String r104, IGetDataCallback<List<ChatChatter>> r105);

    void pickTargetMember(Activity r100, List<String> r101, List<String> r102, boolean r103, String r104, IGetDataCallback<List<ChatChatter>> r105);
}
