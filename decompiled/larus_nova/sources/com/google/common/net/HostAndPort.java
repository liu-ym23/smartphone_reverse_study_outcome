package com.google.common.net;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.common.base.b;
import com.google.common.base.k;
import com.google.common.base.l;
import com.google.common.base.m;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.Arrays;
import javax.annotation.CheckForNull;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes23.dex */
@Immutable
@ElementTypesAreNonnullByDefault
public final class HostAndPort implements Serializable {
    private static final long serialVersionUID = 0;
    private final boolean hasBracketlessColons;
    private final String host;
    private final int port;

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.host, Integer.valueOf(this.port)});
    }

    public boolean hasPort() {
        if (this.port < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public HostAndPort requireBracketsForIPv6() {
        m.h(!this.hasBracketlessColons, "Possible bracketless IPv6 literal: %s", this.host);
        return this;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder(this.host.length() + 8);
        if (this.host.indexOf(58) < 0) goto L5;
        r100.append('[');
        r100.append(this.host);
        r100.append(']');
    L7:
        if (hasPort() == false) goto L10;
        r100.append(':');
        r100.append(this.port);
    L10:
        return r100.toString();
    L5:
        r100.append(this.host);
        goto L7
    }

    public int getPort() {
        m.o(hasPort());
        return this.port;
    }

    public String getHost() {
        return this.host;
    }

    public static HostAndPort fromHost(String r100) {
        HostAndPort r101 = fromString(r100);
        m.h(!r101.hasPort(), "Host has a port: %s", r100);
        return r101;
    }

    public static HostAndPort fromString(String r100) {
        r100.getClass();
        int r101 = -1;
        boolean r102 = false;
        if (r100.startsWith("[") == true) goto L5;
        int r103 = r100.indexOf(58);
        if (r103 < 0) goto L32;
        int r104 = r103 + 1;
        if (r100.indexOf(58, r104) != (-1)) goto L32;
        String r105 = r100.substring(0, r103);
        String r106 = r100.substring(r104);
    L31:
        String r107 = r106;
        boolean r108 = false;
    L36:
        l.a r109 = l.f274724a;
        if (r107 != null) goto L39;
    L42:
        boolean r110 = true;
    L43:
        if (r110 == true) goto L66;
        if (r107.startsWith(Marker.ANY_NON_NULL_MARKER) == true) goto L55;
        b.a r111 = b.a.f274708b;
        r111.getClass();
        int r112 = r107.length() - 1;
    L47:
        if (r112 < 0) goto L52;
        if (r111.c(r107.charAt(r112)) == false) goto L50;
        r112 = r112 - 1;
        goto L47
    L50:
        boolean r113 = false;
    L53:
        if (r113 == false) goto L55;
        boolean r114 = true;
    L56:
        m.h(r114, "Unparseable port number: %s", r100);
        r101 = CastIntegerProtector.parseInt(r107);     // Catch: NumberFormatException -> L63
        if (r101 >= 0) goto L60;
    L62:
        m.h(r102, "Port number out of range: %s", r100);
        goto L66
    L60:
        if (r101 > 65535) goto L62;
        r102 = true;
    L64:
        throw new IllegalArgumentException("Unparseable port number: ".concat(r100));
    L52:
        r113 = true;
    L55:
        r114 = false;
    L66:
        return new HostAndPort(r105, r101, r108);
    L39:
        if (r107.isEmpty() == true) goto L42;
        r110 = false;
    L32:
        if (r103 < 0) goto L34;
        boolean r115 = true;
    L35:
        r107 = null;
        r108 = r115;
        r105 = r100;
        goto L36
    L34:
        r115 = false;
        goto L35
    L5:
        if (r100.charAt(0) != '[') goto L7;
        boolean r116 = true;
    L8:
        m.h(r116, "Bracketed host-port string must start with a bracket: %s", r100);
        int r117 = r100.indexOf(58);
        int r118 = r100.lastIndexOf(93);
        if (r117 <= (-1)) goto L12;
        if (r118 <= r117) goto L12;
        boolean r119 = true;
    L13:
        m.h(r119, "Invalid bracketed host/port: %s", r100);
        String r120 = r100.substring(1, r118);
        int r121 = r118 + 1;
        if (r121 != r100.length()) goto L17;
        String[] r122 = {r120, ""};
    L25:
        r105 = r122[0];
        r106 = r122[1];
        goto L31
    L17:
        if (r100.charAt(r121) != ':') goto L19;
        boolean r123 = true;
    L20:
        m.h(r123, "Only a colon may follow a close bracket: %s", r100);
        int r124 = r118 + 2;
        int r125 = r124;
    L22:
        if (r125 >= r100.length()) goto L24;
        m.h(Character.isDigit(r100.charAt(r125)), "Port must be numeric: %s", r100);
        r125 = r125 + 1;
        goto L22
    L24:
        r122 = new String[]{r120, r100.substring(r124)};
        goto L25
    L19:
        r123 = false;
    L12:
        r119 = false;
        goto L13
    L7:
        r116 = false;
        goto L8
    }

    public boolean equals(@CheckForNull Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof HostAndPort) == false) goto L14;
        HostAndPort r101 = (HostAndPort) r100;
        if (k.a(this.host, r101.host) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.port != r101.port) goto L12;
        return true;
    L14:
        return false;
    }

    public int getPortOrDefault(int r100) {
        if (hasPort() == true) goto L5;
        return r100;
    L5:
        return this.port;
    }

    public HostAndPort withDefaultPort(int r100) {
        if (r100 >= 0) goto L4;
    L6:
        boolean r101 = false;
    L7:
        m.b(r101);
        if (hasPort() == false) goto L11;
        return this;
    L11:
        return new HostAndPort(this.host, r100, this.hasBracketlessColons);
    L4:
        if (r100 > 65535) goto L6;
        r101 = true;
        goto L7
    }

    public static HostAndPort fromParts(String r100, int r101) {
        if (r101 >= 0) goto L5;
    L7:
        boolean r102 = false;
    L8:
        m.d(r102, "Port out of range: %s", r101);
        HostAndPort r103 = fromString(r100);
        m.h(true ^ r103.hasPort(), "Host has a port: %s", r100);
        return new HostAndPort(r103.host, r101, r103.hasBracketlessColons);
    L5:
        if (r101 > 65535) goto L7;
        r102 = true;
        goto L8
    }

    public HostAndPort(String r100, int r101, boolean r102) {
        this.host = r100;
        this.port = r101;
        this.hasBracketlessColons = r102;
    }
}
