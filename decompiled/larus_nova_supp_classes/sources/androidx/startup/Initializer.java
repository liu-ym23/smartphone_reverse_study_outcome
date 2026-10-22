package androidx.startup;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface Initializer<T> {
    T create(Context r1);

    List<Class<? extends Initializer<?>>> dependencies();
}
