package pea;

import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public interface l {

    public static final class a {
        public static /* synthetic */ k a(l r100) {
            return r100.create(Boolean.FALSE);
        }
    }

    k create(Boolean r100);

    Bundle getActions();

    Bundle getPics();

    JSONObject toJSONObject();
}
