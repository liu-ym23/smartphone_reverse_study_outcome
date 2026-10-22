package qpc;

import com.bytedance.lark.pb.basic.v1.ImageSetPassThrough;
import com.bytedance.lark.pb.basic.v1.SerCrypto;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
public interface a {
    Resource getAvatarImageResource(long r100, String r101, int r102, float r103, String r104, String r105);

    String getEmojiImage(String r100, String r101);

    Resource getEncryptImage(String r100, String r101, String r102, ByteString r103, String r104, boolean r105);

    Resource getEncryptImage(String r100, String r101, String r102, ByteString r103, String r104, boolean r105, int r106);

    Resource getPassThroughImage(String r100, String r101, String r102, SerCrypto r103, ImageSetPassThrough.FileType r104);

    String getReactionImage(String r100, String r101);
}
