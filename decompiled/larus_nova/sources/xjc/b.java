package xjc;

import android.content.Context;
import com.byted.cast.common.Logger;
import com.byted.cast.common.api.ICastSink;
import com.byted.cast.common.api.IServerListener;
import com.byted.cast.common.config.Config;
import com.byted.cast.common.sink.IServer;
import com.byted.cast.common.utils.DLNAOptionUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public final class b implements IServer {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f564119e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ICastSink f564120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ICastSink f564121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f564122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f564123d;

    @Override // com.byted.cast.common.sink.IServer
    public final /* synthetic */ void deInit() {
        IServer.CC.$default$deInit(this);
    }

    @Override // com.byted.cast.common.sink.IServer
    public final void setOption(int r100, Object... r101) {
    }

    @Override // com.byted.cast.common.sink.IServer
    public final void setServerListener(IServerListener r100) {
    }

    static {
        f564119e = b.class.getSimpleName();
    }

    @Override // com.byted.cast.common.sink.IServer
    public final void stopServer() {
        String r100 = f564119e;
        Logger.d(r100, "stopServer");
        if (DLNAOptionUtils.isEnableSinkSsdpServer() == true) goto L7;
        Logger.d(r100, "stopServer ssdp server is not open");
        return;
    L7:
        if (this.f564120a != null) goto L9;
        return;
    L9:
        if (((ArrayList) this.f564123d).contains("BDLink") == false) goto L13;
        this.f564120a.stopSsdpServer();
        return;
    }

    @Override // com.byted.cast.common.sink.IServer
    public final void reStartServer() {
        stopServer();
        startServer(this.f564122c, this.f564123d);
    }

    @Override // com.byted.cast.common.sink.IServer
    public final void addProtocols(List<String> r100) {
        ((ArrayList) this.f564123d).clear();
        ((ArrayList) this.f564123d).addAll(r100);
    }

    @Override // com.byted.cast.common.sink.IServer
    public final void setPrivateChannel(String r100) {
        ICastSink r101 = this.f564120a;
        if (r101 == null) goto L6;
        r101.setSsdpPrivateChannel(r100);
        return;
    }

    public b(ICastSink r100, ICastSink r101) {
        this.f564123d = new ArrayList();
        this.f564120a = r100;
        this.f564121b = r101;
    }

    @Override // com.byted.cast.common.sink.IServer
    public final void init(Context r100, Config r101) {
        setPrivateChannel(r101.getPrivateChannel());
    }

    @Override // com.byted.cast.common.sink.IServer
    public final void startServer(String r100, List<String> r101) {
        String r102 = f564119e;
        Logger.d(r102, "startServer");
        if (DLNAOptionUtils.isEnableSinkSsdpServer() == true) goto L6;
        Logger.d(r102, "startServer ssdp server is not open");
        return;
    L6:
        ((ArrayList) this.f564123d).addAll(r101);
        this.f564122c = r100;
        if (this.f564120a != null) goto L9;
        return;
    L9:
        if (((ArrayList) this.f564123d).contains("BDLink") == false) goto L13;
        this.f564120a.startSsdpServer(r100);
        return;
    }
}
