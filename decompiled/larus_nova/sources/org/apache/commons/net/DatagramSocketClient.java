package org.apache.commons.net;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes42.dex */
public abstract class DatagramSocketClient {
    private static final DatagramSocketFactory __DEFAULT_SOCKET_FACTORY = null;
    protected boolean _isOpen_;
    protected DatagramSocketFactory _socketFactory_;
    protected DatagramSocket _socket_;
    protected int _timeout_;
    private Charset charset;

    static {
        __DEFAULT_SOCKET_FACTORY = new DefaultDatagramSocketFactory();
    }

    public void open() throws SocketException {
        DatagramSocket r100 = this._socketFactory_.createDatagramSocket();
        this._socket_ = r100;
        r100.setSoTimeout(this._timeout_);
        this._isOpen_ = true;
    }

    public DatagramSocketClient() {
        this.charset = Charset.defaultCharset();
        this._socket_ = null;
        this._timeout_ = 0;
        this._isOpen_ = false;
        this._socketFactory_ = __DEFAULT_SOCKET_FACTORY;
    }

    public boolean isOpen() {
        return this._isOpen_;
    }

    public void setDefaultTimeout(int r100) {
        this._timeout_ = r100;
    }
}
