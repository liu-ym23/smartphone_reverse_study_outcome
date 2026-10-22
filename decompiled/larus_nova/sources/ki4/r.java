package ki4;

import android.net.Uri;
import com.bytedance.creativex.mediaimport.repository.api.MediaType;
import com.bytedance.creativex.mediaimport.repository.internal.main.MediaItemInternal;

/* JADX INFO: loaded from: classes15.dex */
public interface r {
    MediaItemInternal a(int r100);

    long getDate();

    long getDuration();

    String getFormat();

    int getHeight();

    String getPath();

    long getSize();

    e0 getSourceType();

    MediaType getType();

    Uri getUri();

    int getVersion();

    int getWidth();

    void setHeight(int r100);

    void setWidth(int r100);
}
