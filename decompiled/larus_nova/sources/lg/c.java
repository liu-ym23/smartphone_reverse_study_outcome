package lg;

import com.google.gson.annotations.SerializedName;
import com.ss.texturerender.VideoSurfaceTexture;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Llg/c;", "", "", VideoSurfaceTexture.KEY_TIME, "J", "getTimeStamp", "()J", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class c {

    @SerializedName(VideoSurfaceTexture.KEY_TIME)
    private final long timeStamp;

    public c() {
        this.timeStamp = System.currentTimeMillis();
    }
}
