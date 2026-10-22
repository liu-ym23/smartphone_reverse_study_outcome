package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public class DnsResult implements Serializable {
    public List<String> ipv4List;
    public List<String> ipv6List;
    public Source source;

    public static final enum Source extends Enum<Source> {
        private static final /* synthetic */ Source[] $VALUES = null;
        public static final Source HARDCODE_IPS = null;
        public static final Source HTTPDNS_CACHE = null;
        public static final Source HTTPDNS_REQUEST = null;
        public static final Source HTTPDNS_STALE_CACHE = null;
        public static final Source LOCALDNS_CACHE = null;
        public static final Source LOCALDNS_REQUEST = null;
        public static final Source UNKNOWN = null;

        static {
            Source r100 = new Source("UNKNOWN", 0);
            UNKNOWN = r100;
            Source r101 = new Source("HTTPDNS_CACHE", 1);
            HTTPDNS_CACHE = r101;
            Source r102 = new Source("HTTPDNS_STALE_CACHE", 2);
            HTTPDNS_STALE_CACHE = r102;
            Source r103 = new Source("HTTPDNS_REQUEST", 3);
            HTTPDNS_REQUEST = r103;
            Source r104 = new Source("LOCALDNS_REQUEST", 4);
            LOCALDNS_REQUEST = r104;
            Source r105 = new Source("LOCALDNS_CACHE", 5);
            LOCALDNS_CACHE = r105;
            Source r110 = new Source("HARDCODE_IPS", 6);
            HARDCODE_IPS = r110;
            $VALUES = new Source[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static Source[] values() {
            return (Source[]) $VALUES.clone();
        }

        public static Source valueOf(String r100) {
            return (Source) a.a(Source.class, r100);
        }

        private Source(String r100, int r101) {
            super(r100, r101);
        }
    }

    public DnsResult() {
        this.ipv4List = new ArrayList();
        this.ipv6List = new ArrayList();
        this.source = Source.HTTPDNS_CACHE;
    }
}
