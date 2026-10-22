package okhttp3;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public interface Callback {
    void onFailure(Call r100, IOException r101);

    void onResponse(Call r100, Response r101) throws IOException;
}
