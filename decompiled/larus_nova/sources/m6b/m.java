package m6b;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.keyboard.dtocompat.FrameInfo;
import com.ss.android.lark.keyboard.dtocompat.VideoInfo;
import com.ss.android.lark.todo.impl.features.detail.comment.CommentKeyboardSection$handleActivityResult$1;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public interface m {
    Observable<Map<String, FrameInfo>> Db(List<VideoInfo> r100);

    Observable M4(List r100, boolean r101, CommentKeyboardSection$handleActivityResult$1 r102, Biz r103, Scene r104);

    void d2(String r100, boolean r101, IGetDataCallback<List<MessageInfo>> r102);
}
