package yv;

import com.bytedance.android.gamecp.host_api.model.network.NameValuePair;
import com.bytedance.android.gamecp.host_api.service.IBaseHostService;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public interface b extends IBaseHostService {
    zv.a P1(String r100, List r101) throws IOException;

    zv.a<xv.a> get(String r100, List<NameValuePair> r101) throws IOException;

    String getHostDomain();

    zv.a<xv.a> post(String r100, List<NameValuePair> r101, String r102, byte[] r103) throws IOException;

    zv.a<xv.a> uploadFile(int r100, String r101, List<NameValuePair> r102, String r103, byte[] r104, long r105, String r106) throws IOException;
}
