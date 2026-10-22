package com.ss.android.lark.widget.richtext;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.lark.pb.basic.v1.ImageSetV2;
import com.ss.android.lark.log.Log;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public class MarkdownImageSet implements Serializable {
    private String encodedImageSet;

    public int hashCode() {
        return Objects.hash(new Object[]{this.encodedImageSet});
    }

    public ImageSetV2 toImageSetV2() {
        if (TextUtils.isEmpty(this.encodedImageSet) == false) goto L10;
        return null;
    L10:
        return ImageSetV2.ADAPTER.decode(Base64.decode(this.encodedImageSet, 2));
    L7:
        e = move-exception;
        Log.e("MarkdownImageSet", "toImageSetV2 decode failed: " + e.getMessage());
        return null;
    }

    public MarkdownImageSet() {
    }

    public String getEncodedImageSet() {
        return this.encodedImageSet;
    }

    public static MarkdownImageSet fromImageSetV2(ImageSetV2 r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        MarkdownImageSet r101 = new MarkdownImageSet();
        r101.encodedImageSet = Base64.encodeToString(r100.encode(), 2);     // Catch: Exception -> L8
        return r101;
    L8:
        e = move-exception;
        Log.e("MarkdownImageSet", "fromImageSetV2 encode failed: " + e.getMessage());
        return null;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (getClass() == r100.getClass()) goto L10;
        return false;
    L10:
        return Objects.equals(this.encodedImageSet, ((MarkdownImageSet) r100).encodedImageSet);
    }

    public void setEncodedImageSet(String r100) {
        this.encodedImageSet = r100;
    }
}
