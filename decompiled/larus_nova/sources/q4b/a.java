package q4b;

import android.net.Uri;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.sticker.StickerFileInfo;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import java.io.File;
import java.util.List;
import m5b.b;

/* JADX INFO: loaded from: classes35.dex */
public interface a extends b {
    Message e(String r100, String r101, String r102, String r103, com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r104);

    void f(List<String> r100, boolean r101, String r102, String r103, int r104, String r105, com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r106);

    void h(List<? extends Photo> r100, String r101, String r102, int r103, com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r104);

    void i(List<? extends File> r100);

    void q(List<? extends Uri> r100);

    void r(StickerFileInfo r100, String r101, String r102, PartialReplyInfo r103);
}
