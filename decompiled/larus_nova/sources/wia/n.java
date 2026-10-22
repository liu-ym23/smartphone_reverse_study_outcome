package wia;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import com.obric.capabilitykit.ErrorCodeCallback;
import com.obric.capabilitykit.TaskStateChangeCallback;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.TaskStateInfo;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.intent.IntentResult;
import java.util.Map;

/* JADX INFO: loaded from: classes33.dex */
public interface n {
    void a(long r100);

    void a(String r100, TaskStateInfo r101, TaskStateChangeCallback r102, Long r103);

    void a(String r100, String r101);

    void a(String r100, String r101, String r102);

    boolean a();

    void b(long r100);

    void b(IMAppAction r100);

    Boolean c(long r100);

    void c(Uri r100, String r101);

    void d(Uri r100, String r101, IUriFileReceiver r102);

    PendingIntent e(long r100, Intent r101, FloatingIntentParams r102);

    void f(IntentResult<?> r100, long r101, boolean r102, Map<String, String> r103);

    void g(ErrorCodeCallback r100);

    void h(ErrorCodeCallback r100);

    void i(IntentResult<?> r100, IMAppAction r101);
}
